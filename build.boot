(def project 'clj-nifi-bundle/boot-template)
(def version "0.1.1")

(set-env! :resource-paths #{"resources" "src"}
          :dependencies   '[[org.clojure/clojure "RELEASE"]
                            [seancorfield/boot-new "RELEASE"]])

(task-options!
 pom {:project     project
      :version     version
      :description "A Boot template for clj-nifi projects."
      :url         "https://github.com/big-solutions/clj-nifi-bundle"
      :scm         {:url "https://github.com/big-solutions/clj-nifi-bundle"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[boot.new :refer [new]])
