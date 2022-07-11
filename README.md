# Java Spelling Bee Game

### Abstract / Proje Özeti

Oyunumuzda 7 adet petek görünümlü butonlar bulunmaktadır.Butonların üstünde harfler 
ve ayrıca bir butonumuz merkez harf içermektedir.Kullanıcı verilen harflere göre en az 4 
harf şartı ve merkez harfi içermek koşulu ile kelime üretmeyi amaçlayacaktır.Doğru 
bulduğu kelimeler ile puan kazanması amaçlanmıştır.Bulduğu kelime bir pangram kelime 
ise 7 puan kazanacaktır.Bulduğu kelime pangram kelime dışında bir kelime ise kelime 
sayısı – 3 puan kazanacaktır.Bunların dışında bulduğu kelime sayılarını görebileceği bir 
bilgi kısmı oluşturulmuştur.
Oyunumuzda kullacının iki türlü seçebileceği mod bulunmaktadır.Bu modlar kullanıcının 
düğmelere harflerinin kendi atayabileceği ve harflerin bilgisayar tarafından atanabilceği 
modlardır.Kullanıcı dilediğini seçip oyuna devam edebilecektir.
Oyunumuzda bazı kurallar bulunmaktadır.Kullanıcı 4 harfden az girer ise ‘too short’ hatası 
alacaktır.3 harf şartını sağlayıp Merkez harf içermiyor ise ‘not in the mid letter’ hatası 
alacaktır.Kullanıcının olası hatalarını engellemek amacı ile küçük harf veya sayı girişleri 
engellenmiştir.
Spelling Bee oyunu kullanıcının olası tüm kelimeleri bulmasını kolaylaştırmak amacı ile 
Merkez harfin dışında diğer harfler yer değiştirmesini sağlayan bir buton(düğme) ve 
bulduğu kelimeleri kontrol edebileceği bir ‘giriş’ butonu bulunmaktadır ve aynı şekilde 
yazdığı harfleri silebileceği bir ‘sil’ butonu bulunmaktadır.Bulduğu kelimeler JavaFX 
içerisinde bulunan ListView controller ile gösterilecektir aynı şekilde skoru ise Label 
üzerinde gösterilecektir.

There are 7 honeycomb-like buttons in our game. Letters on the buttons
and also one of our buttons contains a central letter. The user has at least 4 letters according to the given letters.
It will aim to produce words, provided that it contains the letter condition and the central letter.
It is aimed to earn points with the words it finds. The word it finds is a pangram word.
If the word he finds is a word other than the pangram word, he will get 7 points.
number of words – will earn 3 points.
information section.
In our game, there are two modes that the user can choose. These modes are
buttons can be assigned their own letters and letters can be assigned by the computer
They are modes. The user will be able to choose what he wants and continue the game.
There are some rules in our game. If the user enters less than 4 letters, 'too short' error
'not in the mid letter' error if it meets the 3 letter condition and does not contain a central letter
Lower case or number entries in order to prevent possible mistakes of the user.
has been blocked.
Spelling Bee game is designed to make it easier for the user to find all possible words.
A button (button) that allows other letters to be moved apart from the central letter, and
there is a 'login' button where he can check the words he finds and likewise
There is a 'delete' button where he can delete the letters he writes. The words he finds are JavaFX
It will be displayed with the ListView controller in it, and the score will be displayed in the same way as the Label
will be displayed on.


### Software Design / Yazılım Tasarımı

Bal peteği tasarımı bulunmanın dışında CSS kodları ile estetik görünüm 
sağlanmıştır.Tasarımsal süreçleri JavaFX kütüphanesine entegre olarak çalışan 
SceneBuilder aracı ile yürütülmüştür.Tasarımın dışında arka planda çalışan 
algoritmasından bahsetmek gerekir ise; Nesne Tabanlı Programlama hiyerarşisi göz 
önüne alınarak algoritma tasarlanmış ve kodlanmıştır.Birbiri ile bağlantılı sınıfların 
bulunmanın dışında kodların hızlı çalışması adına temel liste yapasının dışında HashSet 
liste yapısı kullanılmıştır.Kullacının harfleri kendi atayabildiği ve bilgisayar tarafından 
atanabildiği iki mod bulunduğundan iki farklı algoritma düşünülmüştür.Kullanıcının 
harfleri kendi atayabildiği modda kullanıcını harfleri girebileceği bir giriş kısmı 
oluşturulmuş ve girdiği harfler karıştırılarak butonlara aktarılmıştır.Bilgisayar tarafından 
atanan modda ise pangram kelimeleri bulunması sağlanan bir sınıf ve ayrıca bulunan 
pangram kelimeler ile ne kadar kelime üretibileceğini veren bir method 
oluşturulmuştur.Oluşturulan bu metotlara göre 20 – 80 arasından üretilebilen pangram 
kelimelerin harfleri butonlara aktarılmıştır.Kullanıcı bu şekilde istenilen tüm kelimeleri 
bulma şansı yakalacaktır.Kullandığımız sınıfların diagramı aşağıda gösterildiği gibidir.

Aesthetic design with CSS codes apart from honeycomb
installation. Working integrated with the design JavaFX library
Executed with the SceneBuilder tool. Running in the background outside of the design
To talk about English; Object Oriented Programming look
They are no longer used and are coded. One of the classes with
HashSet outside of the basic list structure about the fast running of the found rules
list usage. User self-assignable and computer-written
Since there are modes that can be assigned, there are two different.
The introductory part of a section that the user can enter in typed stand-alone mode
It was sent and transferred to the buttons by being a book. Transferred by the computer.
in assigned mode, pangram staff roster is a class and also
a method to produce how many words with pangram words
Application.Pangram can be produced from 20 – 80 according to these methods created
It has been transferred to the buttons where the words are written. The user has been removed from use in this way
It will catch you finding it.


### Conclusion / Sonuç

Projemizi gerçekleştirme sürecinde olası tüm hatalar göz önünde alınıp kontrol edilmiş ve 
olumlu sonuçlar alınmıştır.Kullanıcının butonlara harfleri kendi atadığı modda istenilen 
amaca uygun bir şekilde çalıştığı görülmüş ve harflerin atanmasını kullanıcının kendi 
kararına bırakılmıştır.Projenin bir diğer modu olan harflerin bilgisayar tarafından atandığı 
kısımda ise gerçekleştirilen algoritma çok test edilemeyip istenilen sonuçların tamamı 
alınamamıştır.Takım olarak tasarımın istenilen seviye getirilip kullanıcıya sunulmuştur.


In the process of realizing our project, all possible errors were taken into account and checked and
positive results were obtained. In the mode where the user assigns the letters to the buttons, the desired
It has been seen that it works in accordance with the purpose and the assignment of letters is done by the user himself.
It is left to the decision. Another mode of the project, letters are assigned by the computer.
In the second part, the algorithm performed cannot be tested very much, and all the desired results are
The desired level of the design was brought to the user as a team and presented to the user.
