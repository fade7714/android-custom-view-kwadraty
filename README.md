# Android Custom View — Kolorowe Kwadraty

Aplikacja demonstracyjna na system Android, prezentująca mechanizm tworzenia **Custom View** (własnego widoku) poprzez rozszerzenie klasy `View`. Projekt skupia się na niskopoziomowym rysowaniu grafiki 2D przy użyciu obiektu `Canvas` oraz klasy `Paint`.

---

## 🚀 Funkcje projektu

- **Niestandardowy komponent** — implementacja klasy `Kwadraty` dziedziczącej po `android.view.View`
- **Dynamiczne renderowanie** — losowe generowanie 10 kwadratów o różnych kolorach i rozmiarach przy każdym odświeżeniu widoku
- **Responsywność** — automatyczne dopasowanie obszaru rysowania do rozmiarów ekranu urządzenia (`getWidth()` / `getHeight()`)
- **Efekty graficzne** — wykorzystanie antyaliasingu, wypełnień (`FILL`) oraz obrysów (`STROKE`)

---

## 🛠 Technologie

| Element | Szczegóły |
|---|---|
| Język | Java |
| Platforma | Android SDK |
| Główne klasy | `Canvas`, `Paint`, `Random`, `AttributeSet` |

---

## 💻 Kluczowy fragment kodu

Sercem aplikacji jest nadpisana metoda `onDraw()`, która odpowiada za logikę rysowania figur:

```java
@Override
protected void onDraw(Canvas canvas) {
    int szer = getWidth();
    int wys  = getHeight();

    Paint p = new Paint();
    p.setAntiAlias(true);
    p.setStyle(Paint.Style.FILL);
    Random r = new Random();

    for (int i = 0; i < 10; i++) {
        p.setARGB(255, r.nextInt(256), r.nextInt(256), r.nextInt(256));

        int side = r.nextInt(200) + 20;
        int x    = r.nextInt(Math.max(1, szer - side));
        int y    = r.nextInt(Math.max(1, wys  - side));

        canvas.drawRect(x, y, x + side, y + side, p);
    }

    // Żółta obwódka komponentu
    p.setStyle(Paint.Style.STROKE);
    p.setStrokeWidth(5);
    p.setColor(Color.YELLOW);
    canvas.drawRect(2, 2, szer - 3, wys - 3, p);

    super.onDraw(canvas);
}
```

---

## 📂 Struktura projektu

```
app/
├── java/
│   └── com.example.kwadraty/
│       ├── MainActivity.java      # Aktywność główna, obsługa kliknięcia
│       └── Kwadraty.java          # Własny komponent graficzny
└── res/
    └── layout/
        └── activity_main.xml      # Układ z osadzonym komponentem Kwadraty
```

---

## ▶️ Jak uruchomić

1. Sklonuj repozytorium:
   ```bash
   git clone https://github.com/TWOJ_LOGIN/android-custom-view-kwadraty.git
   ```
2. Otwórz projekt w **Android Studio Panda (2025.3)** lub nowszym.
3. Uruchom aplikację na emulatorze lub fizycznym urządzeniu z Androidem.
4. Kliknij ekran, aby wygenerować nowy zestaw losowych kwadratów.

---

## 📝 Wnioski i podsumowanie

Zrealizowany projekt pozwolił na praktyczne zgłębienie zaawansowanych aspektów tworzenia interfejsu użytkownika poprzez implementację własnego komponentu graficznego. Bezpośrednia praca na obiekcie `Canvas` umożliwiła zrozumienie mechanizmów renderowania grafiki 2D, co jest kluczową umiejętnością przy tworzeniu niestandardowych elementów UI.

Głównym wnioskiem płynącym z realizacji zadania jest zrozumienie roli metody `onDraw()` oraz klasy `Paint`. Istotnym aspektem było zapewnienie responsywności widoku — dzięki dynamicznym obliczeniom generowane figury zawsze mieszczą się w granicach ekranu, niezależnie od rozdzielczości urządzenia. Analiza wydajności pozwoliła również dostrzec wagę optymalizacji zarządzania pamięcią (inicjalizacja obiektów poza pętlą renderowania).

---

## ✍️ Autor

**Bartosz Arcab**
