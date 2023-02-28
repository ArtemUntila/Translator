# Translator

![Testing](https://github.com/Artyom-IWT/Translator/actions/workflows/maven.yml/badge.svg?branch=main)

Simple REST client service with a command-line interface for text translation.

## Usage

Service has two commands:

```
translator [COMMAND]
Commands:
  translate  Translate text
  list       List of supported languages and their codes
```

`translate` command:

```
Usage: translator translate -f=<fromLang> -t=<toLang> <text>
Translate text
      <text>              Text to translate
  -f, --from=<fromLang>   From language
  -t, --to=<toLang>       To language
```

`list` command:

```
Usage: translator list
List of supported languages and their codes
```

## Build

### Maven

Build jar:

```
mvn clean package
```

Run:

```
java -jar target/Translator-jar-with-dependencies.jar list

java -jar target/Translator-jar-with-dependencies.jar translate -f en -t ru "Software Engineering 2022"
```

### Docker

Build Docker image:

```
docker build . -t translator --progress=plain
```

Run Docker container:

```
docker run --rm translator list

docker run --rm translator translate -f en -t ru "Software Engineering 2022"
```

## Example

This example uses Docker.

### `list`

**Correct** usage:

```
docker run --rm translator list
  "af": "Afrikaans", 
  "ar": "Arabic",
  "az": "Azerbaijani",
  "be": "Belarusian",
  "bg": "Bulgarian", 
  "bn": "Bengali",
  "bs": "Bosnian",
  "ca": "Catalan",
  "ceb": "Cebuano",
  "cs": "Czech",
  "cy": "Welsh",
  "da": "Danish",
  "de": "German",
  "el": "Greek",
  "en": "English",
  "eo": "Esperanto",
  "es": "Spanish",
  "et": "Estonian",
  "eu": "Basque",
  "fa": "Persian",
  "fi": "Finnish",
  "fr": "French",
  "ga": "Irish",
  "gl": "Galician",
  "gu": "Gujarati",
  "ha": "Hausa",
  "hi": "Hindi",
  "hmn": "Hmong",
  "hr": "Croatian",
  "ht": "Haitian Creole",
  "hu": "Hungarian",
  "hy": "Armenian",
  "id": "Indonesian",
  "ig": "Igbo",
  "is": "Icelandic",
  "it": "Italian",
  "iw": "Hebrew",
  "ja": "Japanese",
  "jw": "Javanese",
  "ka": "Georgian",
  "kk": "Kazakh",
  "km": "Khmer",
  "kn": "Kannada",
  "ko": "Korean",
  "la": "Latin",
  "lo": "Lao",
  "lt": "Lithuanian",
  "lv": "Latvian",
  "ma": "Punjabi",
  "mg": "Malagasy",
  "mi": "Maori",
  "mk": "Macedonian",
  "ml": "Malayalam",
  "mn": "Mongolian",
  "mr": "Marathi",
  "ms": "Malay",
  "mt": "Maltese",
  "my": "Myanmar (Burmese)",
  "ne": "Nepali",
  "nl": "Dutch",
  "no": "Norwegian",
  "ny": "Chichewa",
  "pl": "Polish",
  "pt": "Portuguese",
  "ro": "Romanian",
  "ru": "Russian",
  "si": "Sinhala",
  "sk": "Slovak",
  "sl": "Slovenian",
  "so": "Somali",
  "sq": "Albanian",
  "sr": "Serbian",
  "st": "Sesotho",
  "su": "Sudanese",
  "sv": "Swedish",
  "sw": "Swahili",
  "ta": "Tamil",
  "te": "Telugu",
  "tg": "Tajik",
  "th": "Thai",
  "tl": "Filipino",
  "tr": "Turkish",
  "uk": "Ukrainian",
  "ur": "Urdu",
  "uz": "Uzbek",
  "vi": "Vietnamese",
  "yi": "Yiddish",
  "yo": "Yoruba",
  "zh-CN": "Chinese Simplified",
  "zh-TW": "Chinese Traditional",
  "zu": "Zulu"
```

**Incorrect** usage:

```
docker run --rm translator list -f
Unknown option: '-f'
Usage: translator list
List of supported languages and their codes
```


### `translate`

**Correct** usage:

```
docker run --rm translator translate -f en -t ru "Software Engineering 2022"
Программная инженерия 2022
```

**Incorrect** usage:
```
docker run --rm translator translate -f en ru "Software Engineering 2022" 
Missing required option: '--to=<toLang>'
Usage: translator translate -f=<fromLang> -t=<toLang> <text>
Translate text
      <text>              Text to translate
  -f, --from=<fromLang>   From language
  -t, --to=<toLang>       To language
```

Unsupported/incorrect language code error:

```
docker run --rm translator translate -f en -t rus "Software Engineering 2022"
Couldn't translate your text.
Use "list" command to see if your --from or --to language is supported and which code corresponds to it.
```