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
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["resources/META-INF/services/org.apache.nifi.processor.Processor"
              (render "org.apache.nifi.processor.Processor" data)]
             [".gitignore" (render ".gitignore" data)]
             [".hgignore" (render ".hgignore" data)]
             ["build.boot" (render "build.boot" data)]
             )))
