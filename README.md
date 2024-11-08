# Rock-Paper-Scissors-Spock-Lizard

Here is an implementation of a generalized form of the game [rock-paper-scissors](https://en.wikipedia.org/wiki/Rock_paper_scissors#Additional_weapons).

At startup, an odd number of non-repeating strings are passed as command line parameters (if the arguments are incorrectly specified, an error message is displayed - what exactly is incorrect, an example of how to get it right). These strings are moves (for example, Rock Paper Scissors Paper or Rock Paper Scissors Paper Lizard Spock or 12 3 456 189).

Winning is determined as follows - half of the next ones in the round win, half of the previous ones in the round lose.

The script generates a cryptographically strong random key at least 256 bits long, makes its move, calculates the HMAC of the move with the generated key and shows it to the user. The user is then presented with the menu 1 - Stone, 2 - Scissors, ..., 0 - Exit. The user makes his choice. The script shows who won, the computer's move and the original key. This way, the user can check that the computer is playing fair.

When the “Help” option is selected, the terminal displays a table determining which move wins.

Example:
```>java -jar game. jar rock papor scissors lizard Spock
HMAC: 9ED6809782D5D9A968E858D7094C75D00F96680DC43CDD6918168A8F50DE8507
Available moves:
1 - rock
2 - paper
3 - scissors
4 - lizard
5 - Spock
0 - exit
? - help
Enter your move: 2
Your move: paper
Computer move: rock
You win!
HMAC key: BD9BE48334BB9C5EC263953DA54727F707E95544739FCE7359C267E734E380A2
```
For ABCDEFG moves - graph who loses to whom:

![image](https://github.com/user-attachments/assets/bf96d2ee-f47f-40d5-becd-1accc315b08b)

# Камень-ножницы-бумага

Здесь представлена реализация обобщенного вида игры [камень-ножницы-бумага](https://en.wikipedia.org/wiki/Rock_paper_scissors#Additional_weapons).

При запуске параметрами командной строки передаётся нечётное число неповторяющихся строк (при неправильно заданных аргументах выводится сообщение об ошибке - что именно неверно, пример как правильно).
Эти строки - это ходы (например, Камень Ножницы Бумага или Камень Ножницы Бумага Ящерица Спок или 12 3 456 189).

Победа определяется так - половина следующих по кругу выигрывает, половина предыдущих по кругу проигрывает.

Скрипт генерирует криптографически стойкий случайный ключ длиной не менее 256 бит, делает свой ход, вычисляет HMAC от хода со сгенерированным ключом и показывает его пользователю.
После этого пользователь получает меню 1 - Камень, 2 - Ножницы, ..., 0 - Exit.
Пользователь делает свой выбор. Скрипт показывает кто победил, ход компьютера и исходный ключ. Таким образом, пользователь может проверить, что компьютер играет честно. 

При выборе опции "helр" в терминале отображается таблица, определющая какой ход выигрывает.

Пример:
```>java -jar game. jar rock papor scissors lizard Spock
HMAC: 9ED6809782D5D9A968E858D7094C75D00F96680DC43CDD6918168A8F50DE8507
Available moves:
1 - rock
2 - paper
3 - scissors
4 - lizard
5 - Spock
0 - exit
? - help
Enter your move: 2
Your move: paper
Computer move: rock
You win!
HMAC key: BD9BE48334BB9C5EC263953DA54727F707E95544739FCE7359C267E734E380A2
```
Для ходов ABCDEFG - граф кто кому проигрывает:

![image](https://github.com/user-attachments/assets/bf96d2ee-f47f-40d5-becd-1accc315b08b)
