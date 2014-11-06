#include <stdio.h>
#include <string.h>

#define BUF_SIZE 128

int pos = 0;

void build(int n, char *s1, char *s2, char *ans)
{
    if(n<=0) return;
    if(1==n) {
        ans[pos++] = s1[0];
        return;
    }

    int p = strchr(s2, s1[0]) - s2;
    //left subtree
    build(p, s1 + 1, s2, ans);
    // right subtree
    build(n-p-1, s1 + 1 + p, s2 + 1 + p, ans);
    ans[pos++] = s1[0];
}

int main(int argc, char **argv)
{
    char s1[BUF_SIZE], s2[BUF_SIZE], ans[BUF_SIZE];
    
    while(scanf("%s%s", s1, s2) == 2) {
        int n = strlen(s1);
        if(n != strlen(s2)) {
            printf("length not equal!\n");
            break;
        }
        pos = 0;
        build(n, s1, s2, ans);
        ans[pos++] = '\0';
        printf("%s\n", ans);
        
    }
    
    return 0;
}
