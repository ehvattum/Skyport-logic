(defun skyport-mode ()
  (interactive)
  (setq truncate-lines t)
  (unhighlight-regexp "G")
  (unhighlight-regexp "R")
  (unhighlight-regexp "E")
  (unhighlight-regexp "C")
  (unhighlight-regexp "O")
  (highlight-regexp "G" 'hi-green)
  (highlight-regexp "E" 'hi-yellow)
  (highlight-regexp "R" 'hi-red-b)
  (highlight-regexp "C" 'hi-pink)
  (highlight-regexp "O" 'hi-black-b)
  )

(provide 'skyport-mode)
