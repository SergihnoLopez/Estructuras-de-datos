#include <iostream> 
using namespace std;

int Head_Num[5]={2,3,5,7},Tail_Num[5]={1,3,7,9}; 
int n;

int check(int x) 
{ 
    int i,j; 
    if(x==2) 
    { 
        return 1; 
    } 
    if(x%2==0) 
    { 
        return 0; 
    } 
    for(i=2;i*i<=x;i++) 
    { 
        if(x%i==0) 
        { 
            return 0; 
        } 
    } 
    return 1; 
}

void DFS(int Num,int N) 
{ 
    int i,j;

    if(N==n) 
    { 
        if(check(Num)) 
        { 
            cout<<Num<<endl; 
        } 
        return ; 
    } 
    for(j=0;j<4;j++) 
    { 
        if(check(Num*10+Tail_Num[j])) 
        { 
            DFS(Num*10+Tail_Num[j],N+1); 
        } 
    } 
}

int main() 
{ 
    cin>>n; 
    DFS(2,1); 
    DFS(3,1); 
    DFS(5,1); 
    DFS(7,1); 
    return 0; 
}

