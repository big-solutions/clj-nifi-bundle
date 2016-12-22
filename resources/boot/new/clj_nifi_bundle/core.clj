(ns {{name}}.core
  (:require [clj-nifi.core :refer :all])
  (:import (org.apache.nifi.processor.util StandardValidators)
           (org.apache.nifi.annotation.documentation CapabilityDescription Tags SeeAlso)
           (org.apache.nifi.annotation.behavior ReadsAttributes WritesAttributes)
           (org.apache.nifi.processor ProcessContext ProcessSession)))

(def success-relationship
  (relationship :name "success" :description "Success"))

(def new-name-property
  (property :name        "New name"
            :description "Name to rename the file"
            :validators  [StandardValidators/NON_EMPTY_VALIDATOR]
            :required    true))

(gen-class :name ^{Tags                  ["nifi" "clojure" "example"]
                   CapabilityDescription "My Clojure-DSL processor"
                   SeeAlso               []
                   ReadsAttributes       []
                   WritesAttributes      []} {{sanitized}}.core.ClojureProcessor
           :extends org.apache.nifi.processor.AbstractProcessor
           :prefix "pf-")

(defn pf-getSupportedPropertyDescriptors [_] [new-name-property])

(defn pf-getRelationships [_] #{success-relationship})

(defn pf-onTrigger [_ ^ProcessContext context ^ProcessSession session]
  (-> (init context session)
      (get-one)
      (put-attribute "filename" "renamed.txt")
      (write "APPENDED SOME CONTENT etc...")
      (transfer success-relationship)))
