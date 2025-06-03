# Home Task 1: Alphabetical Characters Display

## Task Description
Create an Android application that displays all alphabetical characters arranged in rows, with each row containing exactly 4 characters.

## Implementation Details
- Used a ScrollView as the root layout to ensure all content is accessible on smaller screens
- Created 7 rows of LinearLayouts to display all 26 alphabetical characters (A-Z)
- Each row contains exactly 4 TextView elements
- The last row has 2 characters (Y and Z) and 2 empty spaces to maintain the 4-column structure
- Used weight attributes for equal spacing of characters
- Applied consistent styling (font size, padding, gravity) for a clean appearance

## Layout Structure
```
ScrollView
└── LinearLayout (vertical)
    ├── LinearLayout (Row 1: A-D)
    ├── LinearLayout (Row 2: E-H)
    ├── LinearLayout (Row 3: I-L)
    ├── LinearLayout (Row 4: M-P)
    ├── LinearLayout (Row 5: Q-T)
    ├── LinearLayout (Row 6: U-X)
    └── LinearLayout (Row 7: Y-Z + empty spaces)
```

## Screenshot
[Screenshot will be added here]

## Key Concepts Demonstrated
- LinearLayout with weights
- Nested layouts
- ScrollView for scrollable content
- Consistent UI styling 