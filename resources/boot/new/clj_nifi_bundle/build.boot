(def project '{{name}})
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          :dependencies   '[[org.clojure/clojure "1.8.0"]
                            [big-solutions/clj-nifi "0.1.0-SNAPSHOT"]

                            [big-solutions/boot-nifi "0.1.1-SNAPSHOT" :scope "test"]])

(require '[boot-nifi.core :refer [nar-pom nar download-nifi run-nifi]])


(deftask build
         "Builds the application."
         []
         (comp (pom :project project
                    :version version)
               (aot :all true)
               (jar)
               (install)
               (nar :project project
                    :version version)
               (target)))

(deftask run
         "Runs the application in a local NiFi container"
         []
         (comp (build)
               (sift :include #{#".*\.nar"})
               (target :dir #{"nifi-home/lib"} :no-clean true)
               (run-nifi)
               (wait)))
