(ns boot.new.clj-nifi-bundle
  (:require [boot.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "clj-nifi-bundle"))

(defn clj-nifi-bundle
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (println "Generating fresh 'boot new' clj-nifi-bundle project.")
    (->files data
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
