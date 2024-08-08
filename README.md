## Утилита фильтрации содержимого файлов

### Описание

Эта утилита разделяет содержимое входных файлов на отдельные файлы в зависимости от типов данных: целые числа, вещественные числа и строки. Входные файлы содержат данные, разделенные переводами строки.

### Возможности

- **Раздельные выходные файлы**:
  - Целые числа в `integers.txt`
  - Вещественные числа в `floats.txt`
  - Строки в `strings.txt`

- **Настраиваемый вывод**:
  - `-o` для указания директории вывода.
  - `-p` для указания префикса имен файлов.
  - `-a` для добавления данных к существующим файлам.

- **Статистика**:
  - Краткая (`-s`): количество элементов.
  - Полная (`-f`): включает минимум, максимум, сумму и среднее для чисел, длину самой короткой и длинной строки.

- **Обработка ошибок**:
  - Устойчивое к ошибкам выполнение с информативными сообщениями.

### Требования

- **Версия Java**: 21
- **Система сборки**: Maven 3.8.1
- **Зависимости**:
  - Lombok 1.18.34

### Установка и запуск

1. **Сборка проекта**:
    ```bash
    mvn clean package
    ```

2. **Запуск утилиты**:
    ```bash
    java -jar target/util-1-jar-with-dependencies.jar -f -p sample- in1.txt in2.txt
    ```

### Примечания

- Утилита обрабатывает файлы в порядке их перечисления в командной строке.
- Пустые выходные файлы не создаются, если данные отсутствуют.
- Убедитесь, что Java и Maven установлены и настроены.

#### Пример запуска

```bash
  java -jar target/util-1-jar-with-dependencies.jar -f -p sample- in1.txt in2.txt
```

#### Выходные файлы

- `sample-integers.txt`
- `sample-floats.txt`
- `sample-strings.txt`

#### Пример статистики

- *Краткая статистика*: 
```bash
  sample-floats.txt statistics: elements = 3
  sample-strings.txt statistics: elements = 7
  sample-integers.txt statistics: elements = 2
```

- *Полная статистика*:
```bash
  sample-floats.txt statistics: elements = 3
  min = -0.001, max = 3.1415, sum = 3.1405000000000003, average = 1.0468333333333335
  sample-strings.txt statistics: elements = 7
  shortest length = 4, longest length = 42
  sample-integers.txt statistics: elements = 2
  min = 100500, max = 123456789, sum = 1.23557289E8, average = 6.17786445E7
```

## Лицензия

Этот проект лицензирован под лицензией MIT. Подробности смотрите в файле `LICENSE`.

## Контакты

1. Telegram: [https://t.me/yet_another_name](https://t.me/yet_another_name)
2. LinkedIn: [https://www.linkedin.com/in/daniil-tiunchyk/](https://www.linkedin.com/in/daniil-tiunchyk/)
3. Gmail: [fcad.td@gmail.com](mailto:fcad.td@gmail.com)
