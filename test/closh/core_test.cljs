(ns closh.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [clojure.spec.alpha :as s]
            [closh.parser]))
  ; (:require-macros [closh.core :refer [sh shh]]))

; (s/conform ::cmd-list '(ls -l))
; (s/conform ::cmd-list '((+ 1 2)))
; (s/conform ::cmd-list '(ls *.txt))
; (s/conform ::cmd-list '(ls $HOME))
; (s/conform ::cmd-list '(ls |> (reverse) | head))
; (s/conform ::cmd-list '(ls | #(str/replace % #"\.txt" ".md")))
; (s/conform ::cmd-list '(ls | (str/upper-case)))
; (s/conform ::cmd-list '(ls -a | grep "^\\."))
; (s/conform ::cmd-list '(diff <(sh sort L.txt) <(sh sort R.txt)))
; (s/conform ::cmd-list '(echo x > tmp.txt))
; (s/conform ::cmd-list '(ls .))
; (s/conform ::cmd-list '(ls |> (spit "files.txt")))
;
; (s/conform ::cmd-list '(echo (sh date)))
;
; ; todo symbols with slashes like paths
; (s/conform ::cmd-list '(cat a/b/c/d))
; (s/conform ::cmd-list '(cat /a/b/c/d))
;
; ; todo Invalid number handling:
; (s/conform ::cmd-list '(echo x 2> tmp.txt))
; (s/conform ::cmd-list '(echo hi 1>&2))

; (s/conform ::cmd-list '())

(defn parse [x]
  (closh.parser/process-command-list (s/conform :closh.parser/cmd-list x)))

(deftest run-test
  ; (is (= (s/conform :closh.parser/cmd-list '(ls -l))
  ;        []))

  (is (= (parse '(ls -l))
         '(shx "ls"  "-l"))))