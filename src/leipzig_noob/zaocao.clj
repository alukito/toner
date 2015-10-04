(ns leipzig-noob.zaocao
  (:use [leipzig melody scale live]
        [overtone.inst.piano])
  (:require [overtone.live :as overtone]
            [overtone.studio.midi :as midi]))

(def synth-out (first (midi/midi-connected-receivers)))

(defn midiout
  [pitch duration]
  (midi/midi-note synth-out pitch 100 duration))

(defmethod play-note :default [{midi :pitch duration :duration}]
  (when midi (midiout midi (* 1500 duration))))

;(defmethod play-note :default [{midi :pitch}]
;  (when midi (piano midi)))

(defn play-music [music]
  (->>
    music
    (tempo (bpm 20))
    play))

(def bass1
  (phrase [1/8  1/4   1/8   1/8  1/4   1/8 ]
          [0   [2 4] [2 4]  -1  [2 4] [2 4]]))
(def bass2
  (phrase [1/8  1/4     1/8    1/8    1/4   1/8
           1/8  1/4     1/8    1/8    1/4   1/8
           1/8  1/8     1/8    1/8    1/8   1/8  1/8  1/8
           1/8  1/4     1/8    1/8    1/4   1/8
           1/8  1/4     1/8    1/8    1/4   1/8
           1/8  1/4     1/8    1/8    1/4   1/8
           1/8  1/8     1/8    1/8    1/8   1/8  1/8  1/8]
          [-2  [2 4]   [2 4]   -3    [2 4] [2 4]
           -4  [2 5]   [2 5]   -5    [2 4] [2 4]
           -6  [1 7/2] -7/2  [1 7/2]   -3   -10  -9   -8
           -7  [2 4]   [2 4]   -8    [2 4] [2 4]
           -9  [2 4]   [2 4]   -10   [2 4] [2 4]
           -11 [2 5]   [2 5]   -12   [2 4] [2 4]
           -6    5     -7/2     5     -3    -10  -9   -8]))

(def bass3
  (phrase [1/8  1/4    1/8     1/8     1/4     1/8
           1/8  1/4    1/8     1/8     1/4     1/8
           1/8  1/4    1/8     1/8     1/4     1/8
           1/8  1/8    1/8     1/8     1/8     1/8  1/8  1/8
           1/8  1/4    1/8     1/8     1/4     1/8]
          [-7  [0 2]   [0 2]   -8     [0 2]   [0 2]
           -9  [0 2]   [0 2]   -10    [0 2]   [0 2]
           -4  [0 2]   [0 2]   -5     [0 2]   [0 2]
           -6  [1 7/2] -7/2    [7/2 5] -3      -10   -9   -8
           -6  [1 7/2] [1 7/2] -13/2  [1 7/2] [1 7/2]]))

(def bass-f
  (->>
   bass1
   (times 3)
   (then bass2)
   (then bass3)
   (where :pitch (comp low F major))))

(def bass4
  (phrase [1/8  1/4   1/8   1/8     1/4   1/8
           1/8  1/4   1/8   1/8     1/4   1/8
           1/8  1/8   1/8   1/8     1/8   1/8  1/8  1/8
           1/8  1/4   1/8   1/8     1/4   1/8
           1/8  1/4   1/8   1/8     1/4   1/8
           1/8  1/4   1/8   1/8     1/4   1/8
           1/8  1/8   1/8   1/8     1/8   1/8  1/8  1/8]
          [-9  [0 2] [0 2]  -10    [0 2] [0 2]
           -4  [0 2] [0 2]  -5     [0 2] [0 2]
           -6    1   -7/2  [7/2 5]  -3    -10  -9   -8
           -7  [2 4] [2 4]  -8     [2 4] [2 4]
           -9  [2 4] [2 4]  -10    [2 4] [2 4]
           -11 [2 5] [2 5]  -12    [2 4] [2 4]
           -6    5     -7/2  5      -3    -10  -9   -8]))

(def bass5
  (phrase [1/8  1/4   1/8   1/8  1/4   1/8]
          [ 0  [2 4] [2 4]  -1  [2 4] [2 4]]))

(def bass-g
  (->>
   bass4
   (then (times 4 bass5))
   (where :pitch (comp low G major))))

(def intro-rest
  (phrase [2] [nil]))

(def melody1
  (phrase [1/4   1/8  1/8  1/4   1/8 1/8
           1/4   1/8  1/8  1/8   1/8 1/8 1/16 1/16
           1/4   1/8  1/8  1/4   1/8 1/8
           1/4   1/8  1/8  1/4   1/4
           1/4   1/8  1/8  1/4   1/8 1/8
           1/4   1/8  1/8  1/8   1/8 1/8 1/16 1/16
           1/4   1/8  1/8  1/4   1/8 1/8
           1/8   1/8  1/8  1/8   1/4 1/4]
          [ 2     2    3    2     2   3
            2     2    3    4     3   2   0    1
            2     2    3    2     0   1
            2   [1 -2] 0  [1 -1]  4
          [0 2] [0 2]  3  [0 2] [0 2] 3
          [0 2] [0 2]  3    4     3   2   0    1
          [0 2]   2    3  [0 2]   0   1
            2     1 [1 -2]  0     1   4 ]))

(def melody2
  (phrase (repeat 8 1/16)
          [9 4 9 4 9 4 10 4]))

(def melody3
  (phrase (repeat 8 1/16)
          [11 4 10 4 9 4 7 8]))

(def melody4
  (phrase (repeat 16 1/16)
          [9 5 9 5 9 5 10 5 9 4 9 4 9 4 7 8]))

(def melody5
  (phrase (concat (repeat 8 1/16) [1/2])
          [9 7/2 9 7/2 8 7/2 7 7/2 [6 8]]))

(def melody6
  (phrase (repeat 8 1/16)
          [21/2 5 21/2 5 21/2 5 11 5]))

(def melody-f
  (->>
   intro-rest
   (then melody1)
   (then (times 3 melody2))
   (then melody3)
   (then melody4)
   (then melody5)
   (then (times 2 melody6))
   (wherever :pitch, :pitch (comp F major))))

(def melody8
  (phrase (repeat 16 1/16)
          [9 5 9 5 9 5 10 5  9 7  9 7 9 4 7 8]))

(def melody9
  (phrase [ 1/4   1/8  1/8  1/4   1/8  1/8
            1/4   1/8  1/8  1/8   1/8  1/8 1/16 1/16
            1/4   1/8  1/8  3/8   1/16 1/16
            1/16  1/16 1/16 1/16  1/4  1/4]
          [[0 2] [0 2]  3  [0 2] [0 2]  3
           [0 2] [0 2]  3    4     3    2   0    1
             2   [0 2]  3    2     0    1
             2     1    1    0     1    4]))

(def melody10
  (phrase [1/2 1/2] [9 9]))

(def melody-g
  (->>
   melody2
   (then melody3)
   (then melody8)
   (then melody5)
   (then melody9)
   (then (times 4 melody10))
   (wherever :pitch, :pitch (comp G major))))

(play-music
 (->>
  (with bass-f melody-f)
  (then (with bass-g melody-g))))
