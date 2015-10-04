(ns leipzig-noob.luxiaoyu
  (:use [leipzig melody scale live]
        [overtone.inst.piano])
  (:require [overtone.live :as overtone]
            [shadertone.tone :as t]))

(defmethod play-note :default [{midi :pitch}]
  (when midi (piano midi)))

(defn play-music [music]
  (->>
    music
    (where :time (bpm 19))
    (where :duration (bpm 19))
    (where :pitch overtone/note)
    play))

(def phrase-riff1
  (times 2
         (phrase [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16]
                 [:C3  :G3  :C4  :D4  :E4  :D4  :C4  :E4 ])))
phrase-riff1
(def phrase-riff2
  (times 2
         (phrase [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16]
                 [:E3  :G3  :B3  :C4  :D4  :C4  :B3  :D4 ])))

(def phrase-riff3
  (times 2
         (phrase [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16]
                 [:F3  :A3  :C4  :D4  :E4  :D4  :C4  :E4 ])))

(def phrase-riff4
  (times 2
         (phrase [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16]
                 [:F3  :A#3 :C4  :D4  :E4  :D4  :C4  :E4 ])))

(def phrase-riff5
  (times 2
         (phrase [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16]
                 [:E3  :G3  :B3  :C4  :G4  :C4  :B3  :G4 ])))

(def phrase-riff6
  (times 2
         (phrase [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16]
                 [:Eb3 :F#3 :A3  :C4  :F#4 :C4  :A3  :F#4])))

(def phrase-riff7
  (times 2
         (phrase [1/16 1/16 1/16 1/16    1/16   1/16 1/16   1/16   ]
                 [:D3  :F3  :A3  :C4  [:F4 :A4] :C4  :A3  [:F4 :A4]])))

(def phrase-riff8
  (phrase [1/16 1/16 1/16 1/16    1/16   1/16 1/16   1/16
           1/16 1/16 1/16 1/16    1/16   1/16 1/16   1/16   ]
          [:G2  :F3  :C4  :F4  [:A4 :C5] :F4  :C4  [:A4 :C5]
           :G2  :F3  :C4  :F4  [:B4 :D5] :F4  :C4  [:B4 :D5]]))

(def phrase-riff9
  (phrase [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16
           1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16
           1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16]
          [:D5  :E4  :G4  :D5  :C5  :E4  :G4  :C5  :B4  :D4  :F4  :B4  :C5  :E4  :G4  :C5
           :D5  :E4  :A4  :D5  :C5  :E4  :A4  :C5  :B4  :E4  :G4  :B4  :C5  :E4  :A4  :C5
           :E5  :F#4 :A4  :E5  :D5  :F#4 :A4  :D5  :C5  :F#4 :A4  :C5  :D5  :F#4 :A4  :D5]))

(def phrase-riff10
  (phrase [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16]
          [:E5  :F4  :G#4 :E5  :D5  :F4  :Ab4 :D5  :C5  :C4  :F4  :C5  :D5  :D4  :F4  :D5]))

(def phrase-riff11
  (phrase [1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16 1/16]
          [:E5  :F4  :G#4 :E5  :D5  :F4  :Ab4 :D5  :C5  :C4  :F4  :C5  :B4  :D4  :G4  :D4]))

(def phrase-riff12
  (phrase [1/64 1/64 (+ 1/2 1/4 1/8)]
          [:C4  :D4       :E4]))


(def phrase-bass1
  (phrase
   [    1         1          1         1/2        1/2  ]
   [[:C3 :C2] [:A2 :A1] [:F#2 :F#1] [:F2 :F1] [:G2 :G1]]))

(def phrase-bass2
  (phrase [1] [[:C3 :C2]]))

(def melody
  (phrase
    [15/4
      1/4 3/4 1/4 3/4 1/4
      3/4 1/4 1/4 1/4 1/4 1/4 3/4 1/4
      3/4 1/4 3/4 1/4 1/4 1/4 1/4 1/4
      3/4 1/4 3/4 1/4 1/2 1/2
      1/2 1/2 1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4
      1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4
      1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4 1/4
      3/4 1/4 3/4 1/4
      3/4 1/4 1/4 1/4 1/4 1/4 1]
    [ nil
      :F5 :E5 :E5 :D5 :D5
      :C5 :C5 :G5 :F5 :C5 :D5 :E5 :E5
      :B5 :C6 :A5 :A5 :E6 :F6 :C6 :D6
      :B5 :G5 :A5 :A5 :E6 :C6
      :E6 :C6 :D6 :C6 :B5 :C6 :D6 :C6 :B5 :C6
      :E6 :D6 :C6 :D6 :E6 :D6 :F6 :E6 :D6 :C6 :B5 :C6
      :D6 :C6 :B5 :C6 :E6 :D6 :C6 :D6 :E6 :D6 :F6 :E6
      :C6 :E6 :D6 :D6
      :C6 :C6 :G6 :F6 :C6 :D6 :C6]))

(def verse1
  (->>
   phrase-riff1
   (then phrase-riff2)
   (then phrase-riff3)
   (then phrase-riff4)
   (times 3)
   (then phrase-riff5)
   (then phrase-riff6)
   (then phrase-riff7)
   (then phrase-riff8)))



(def reff
   (with
    (times 2 phrase-bass1)
    (->>
     phrase-riff9
     (then phrase-riff10)
     (then phrase-riff9)
     (then phrase-riff11))))

(def verse2
  (->>
   phrase-riff1
   (then phrase-riff2)
   (then phrase-riff3)
   (then phrase-riff4)
   (then (with phrase-bass2 phrase-riff12))))

(def music
  (->>
   verse1
   (then reff)
   (then verse2)
   (with melody)))

(play-music music)


