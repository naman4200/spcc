%{
#include <stdio.h>
int char_count = 0;
int word_count = 0;
int sentence_count = 0;
int line_count = 0;
int tab_count = 0;
int number_count = 0;
int space_count = 0;
%}

%%
[0-9]+          { number_count++; char_count += yyleng; }
[ \t]+          {
                   for (int i = 0; i < yyleng; i++) {
                       if (yytext[i] == ' ') space_count++;
                       else if (yytext[i] == '\t') tab_count++;
                   }
                   char_count += yyleng;
               }
\n              { line_count++; char_count++; }
[.!?]           { sentence_count++; char_count++; }
[a-zA-Z]+       { word_count++; char_count += yyleng; }
.               { char_count++; }  // Catch all other characters
%%

int main() {
    printf("Enter the input (Ctrl+D to end):\n");
    yylex();

    printf("\n--- Result ---\n");
    printf("Characters: %d\n", char_count);
    printf("Words: %d\n", word_count);
    printf("Sentences: %d\n", sentence_count);
    printf("Lines: %d\n", line_count);
    printf("Tabs: %d\n", tab_count);
    printf("Numbers: %d\n", number_count);
    printf("Blank spaces: %d\n", space_count);

    return 0;
}

int yywrap() {
    return 1;
}



Command to run

lex count.l
gcc lex.yy.c -o count -ll
./count
