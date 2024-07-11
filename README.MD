# Виселица (также известна как «Балда») 
реализация на Java, описание задания 
https://zhukovsd.github.io/java-backend-learning-course/Projects/Hangman/

Принцип игры
----------

Один из игроков загадывает слово — пишет на бумаге любые две буквы слова и отмечает места для остальных букв, например чертами (существует также вариант, когда изначально все буквы слова неизвестны). Также рисуется виселица с петлёй.

Согласно традиции русских лингвистических игр, слово должно быть именем существительным, нарицательным в именительном падеже единственного числа, либо множественного числа при отсутствии у слова формы единственного числа.

Второй игрок предлагает букву, которая может входить в это слово. Если такая буква есть в слове, то первый игрок пишет её над соответствующими этой букве чертами — столько раз, сколько она встречается в слове. Если такой буквы нет, то к виселице добавляется круг в петле, изображающий голову. Второй игрок продолжает отгадывать буквы до тех пор, пока не отгадает всё слово. За каждый неправильный ответ первый игрок добавляет одну часть туловища к виселице (обычно их 6: голова, туловище, 2 руки и 2 ноги, существует также вариант с 8 частями — добавляются ступни, а также самый длинный вариант, когда сначала за неотгаданную букву рисуются части самой виселицы).

Если туловище в виселице нарисовано полностью, то отгадывающий игрок проигрывает, считается повешенным. Если игроку удаётся угадать слово, он выигрывает и может загадывать слово.




Пример игры
--------
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">0
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-0.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Hangman-0.png/50px-Hangman-0.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Hangman-0.png/75px-Hangman-0.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Hangman-0.png/100px-Hangman-0.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ _ _ _ _ _</b><br />
Ошибки (0): <span style="color:red;"></span><br />
Буква: А
</p>
</td></tr></tbody></table>
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">1
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-1.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/3/30/Hangman-1.png/50px-Hangman-1.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/3/30/Hangman-1.png/75px-Hangman-1.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/3/30/Hangman-1.png/100px-Hangman-1.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ _ _ _ _ _</b><br />
Ошибки (1): <span style="color:red;">а</span><br />
Буква: О
</p>
</td></tr></tbody></table>
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">2
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-1.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/3/30/Hangman-1.png/50px-Hangman-1.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/3/30/Hangman-1.png/75px-Hangman-1.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/3/30/Hangman-1.png/100px-Hangman-1.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ _ О _ _ _</b><br />
Ошибки (1): <span style="color:red;">а</span><br />
Буква: Н
</p>
</td></tr></tbody></table>
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">3
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-2.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/7/70/Hangman-2.png/50px-Hangman-2.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/7/70/Hangman-2.png/75px-Hangman-2.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/7/70/Hangman-2.png/100px-Hangman-2.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ _ О _ _ _</b><br />
Ошибки (2): <span style="color:red;">а, н</span><br />
Буква: Р
</p>
</td></tr></tbody></table>
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">4
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-3.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/9/97/Hangman-3.png/50px-Hangman-3.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/9/97/Hangman-3.png/75px-Hangman-3.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/9/97/Hangman-3.png/100px-Hangman-3.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ _ О _ _ _</b><br />
Ошибки (3): <span style="color:red;">а, н, р</span><br />
Буква: С
</p>
</td></tr></tbody></table>
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">5
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-4.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/2/27/Hangman-4.png/50px-Hangman-4.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/2/27/Hangman-4.png/75px-Hangman-4.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/2/27/Hangman-4.png/100px-Hangman-4.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ _ О _ _ _</b><br />
Ошибки (4): <span style="color:red;">а, н, р, с</span><br />
Буква: Т
</p>
</td></tr></tbody></table>
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">6
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-5.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Hangman-5.png/50px-Hangman-5.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Hangman-5.png/75px-Hangman-5.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Hangman-5.png/100px-Hangman-5.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ _ О _ _ _</b><br />
Ошибки (5): <span style="color:red;">а, н, р, с, т</span><br />
Буква: К
</p>
</td></tr></tbody></table>
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">7
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-5.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Hangman-5.png/50px-Hangman-5.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Hangman-5.png/75px-Hangman-5.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Hangman-5.png/100px-Hangman-5.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ _ О _ _ К</b><br />
Ошибки (5): <span style="color:red;">а, н, р, с, т</span><br />
Буква: Л
</p>
</td></tr></tbody></table>
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">8
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-5.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Hangman-5.png/50px-Hangman-5.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Hangman-5.png/75px-Hangman-5.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Hangman-5.png/100px-Hangman-5.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ Л О _ _ К</b><br />
Ошибки (5): <span style="color:red;">а, н, р, с, т</span><br />
Буква: И
</p>
</td></tr></tbody></table>
<table cellpadding="1" cellspacing="1" border="0" style="border: 1px solid #dddddd; width:400px; margin-bottom:.2em;">
<tbody><tr>
<td valign="center" style="width: 2em;">9
</td>
<td style="width: 60px;"><span typeof="mw:File"><a href="/wiki/%D0%A4%D0%B0%D0%B9%D0%BB:Hangman-6.png" class="mw-file-description"><img src="//upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Hangman-6.png/50px-Hangman-6.png" decoding="async" width="50" height="50" class="mw-file-element" srcset="//upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Hangman-6.png/75px-Hangman-6.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Hangman-6.png/100px-Hangman-6.png 2x" data-file-width="256" data-file-height="256" /></a></span>
</td>
<td>
<p>Слово: <b>_ _ Л О _ _ К</b><br />
Ошибки (6): <span style="color:red;">а, н, р, с, т, и</span><br />
Буква:
</p>
</td></tr></tbody></table>
