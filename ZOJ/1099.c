#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DELIMITERS " \t\n"
#define LINE_LEN 80

int pos = 0;

void display_hr()
{
    int i;

    if(pos)
        printf("\n");

    for(i=0; i<80 ; i++)
        printf("-");

    printf("\n");
    pos = 0;
}

void parse_element(char *tok)
{
    int len;
    char *p;

    if(tok == NULL) return;

    if((p = strstr(tok, "<br>")) != NULL) {
        char prev[LINE_LEN];
        // deal with string ahead of <br>
        if(tok != p) {
            memcpy(prev, tok, p - tok);    
            prev[p - tok] = '\0';
            parse_element(prev);
        }
        // deal with <br>
        printf("\n");
        pos = 0;
        // deal with string ahead of <br>
        parse_element(p + 4);
        return;
    }

    if((p = strstr(tok, "<hr>")) != NULL) {
        char prev[LINE_LEN];
        // deal with string ahead of <hr>
        if(tok != p) {
            memcpy(prev, tok, p - tok);    
            prev[p - tok] = '\0';
            parse_element(prev);
        }
        // deal with <hr>
        display_hr();
        // deal with string ahead of <hr>
        parse_element(p + 4);
        return;
    }

    // Now we only need to deal with words
    len = strlen(tok);
    if((pos+len) >= LINE_LEN) {
        printf("\n");
        pos = 0;
    }

    if(pos != 0) {
        printf(" ");
        pos++;
    }
    printf("%s", tok);
    pos += strlen(tok);
}

int main(int argc, char **argv)
{
    char *line = NULL;
    char *tok;
    size_t  len = 0;
    ssize_t read;
    int rtval;

    while((read = getline(&line, &len, stdin)) != -1) {
        if(0 == strcmp(line, "\n"))
            continue;
        tok = strtok(line, DELIMITERS);
        while(tok != NULL) {
            parse_element(tok);
            tok = strtok(NULL, DELIMITERS);
        }
    }
    printf("\n");

    free(line);
    return 0;
}
