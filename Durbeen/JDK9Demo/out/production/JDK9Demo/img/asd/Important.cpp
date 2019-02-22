
/*Which of the favors of your Lord will you deny ?*/

#include<bits/stdc++.h>
using namespace std;

#define PII pair<int,int>
#define MP make_pair
#define LL long long
#define F first
#define S second

//Bit Related (Caution Long Long hoile 1 er typecasting needed 1LL)

int bit_on(int n,int pos)
{
  return n=(n|(1<<pos)); // only (n|(1<<pos) is enough also
}

int bit_off(int n,int pos)
{
  return n=(n&(~(1<<pos)));
}

int ki_ase(int num,int bit)
{
    if((num&(1<<bit))==0) //bracket bracket bracket -_-
        return 0;
    else return 1;
}

int bit_toggle(int n,int pos)
{
  return n=(n^(1<<pos));
}

//Sorting (cmp function)

sort(v.begin(),v.end(),cmp);

bool cmp(const PII &a,const PII &b) //a demo of cmp function (ekhane val1 ar val2 er upor base kore choto theke boro sort kora hoyeche)
{
    double val1= (a.second*1.0/a.first);
    double val2= (b.second*1.0/b.first);

    if(val1<val2)
        return 1;
    else
        return 0;
}

bool cmp(const PII &a,const PII &b)
{
    if(a.first==b.first)
        return a.second>b.second; // same hoye gele 2nd tar boro ta upore thakbe
    else return a.first>b.first; // first er tar onujayi boro theke choto sort
}

bool cmp2(const PII &a,const PII &b)
{
    if(a.first>b.first)
        return 1;
    else if(a.first==b.first)
    {
        if(a.second>b.second)
            return 1;
        else return 0;
    }
    else
        return 0;
}

// decToBin

int decToBin(int n)
{
    for (int i = 31; i >= 0; i--)
    {
        if ((n&(1<<i))==0)
            printf("0");
        else
            printf("1");
    }
}

int decToBin2(int n) //returns an int of binary value
{
    if(n==0)
        return 0;
    else
        return (n%2+10*decToBin2(n/2));
}

//Power with Recursion in O(logN)

LL powa(int x,int y)
{
    if(y==0)
        return 1;

    LL temp = powa_rec(x,y/2);

    if((y&1)==0) // (y%2==0) // LL korle 1LL
        return temp*temp;
    else
        return x*temp*temp;

}

//bigMod

unsigned LL bigMod(int x,int n,int mo)
{
    if(n==0)
        return 1;

    unsigned LL u = bigMod(x,n/2,mo);

    u = ((u%mo)*(u%mo))%mo;

    if(n%2==1)
        u = ((u%mo)*(x%mo))%mo;

    return u;
}

//Modular Inverse

unsigned LL modInverse(int a,int mo)
{
    unsigned LL uttor = bigMod(a,mo-2,mo);

    return uttor;
}

// Sieve
LL LIM = 10000000;
bool isP[10000005];
vector<LL>primes;

void sieve()
{
    for(int j=1;j<=LIM;j++)
            isP[j]=true;

    for(LL i=2; i<=LIM; i++)
    {
            if(isP[i]==true)
            {
                    primes.push_back(j);
                    for(LL j=i*i; j<=LIM; j+=i)
                        isP[j]=false;
            }
    }

}

//Segmented sieve

void segmented_sieve(LL A ,LL B)
{
    for(int i=0; i<=LIM; i++)
        isPFinal[i]=true;

    for(int i=0;i<primes.size();i++)
    {
        LL p=primes[i];
        LL j=p*p;

        if(j<A)
            j=((A+p-1)/p)*p;

        for(;j<=B;j+=p)
            isPFinal[j-A]=false;

    }

    for(LL i=A;i<=B;i++)
    {
        if(i==(LL)1)
            continue;

        if(isPFinal[i-A])
        {
            printf("%lld\n",i);
        }
    }

}

// Segmented Sieve Efficient (Zobayer)

/*
Generates primes within interval [a, b] when b - a <= 100000
and 1 <= a <= b <= 2147483647
*/
int base[MAX>>6], segment[RNG>>6], primes[LEN], prlen;

#define chkC(x,n) (x[n>>6]&(1<<((n>>1)&31)))
#define setC(x,n) (x[n>>6]|=(1<<((n>>1)&31)))

void sieve() {
    int i, j, k;
    for(i=3; i<LMT; i+=2) if(!chkC(base, i)) for(j=i*i, k=i<<1; j<MAX; j+=k) setC(base, j);
    for(i=3, prlen=0; i<MAX; i+=2) if(!chkC(base, i)) primes[prlen++] = i;
}

int segmented_sieve(int a, int b) {
    int rt, i, k, cnt = (a<=2 && 2<=b)? 1 : 0;
    if(b<2) return 0;
    if(a<3) a = 3;
    if(a%2==0) a++;
    memset(segment, 0, sizeof segment);
    for(i=0, rt=(int)sqrt((double)b); i < prlen && primes[i] <= rt; i++) {
        unsigned j = primes[i] * ( (a+primes[i]-1) / primes[i] );
        if(j%2==0) j += primes[i];
        for(k=primes[i]<<1; j<=b; j+=k) if(j!=primes[i]) setC(segment, (j-a));
    }
    for(i=0; i<=b-a; i+=2) if(!chkC(segment, i)) cnt++;
    return cnt;
}

//CSNOD in Complexity O(sqrt(N)) // Cumulative Sum of Number of Divisors

int CNOD( int n ) {
    int res = 0;
    int u = sqrt(n);
    for ( int i = 1; i <= u; i++ ) {
        res += ( n / i ) - i; //Step 1
    }
    res *= 2; //Step 2
    res += u; //Step 3
    return res;
}

//CSOD in Complexity O(sqrt(N)) // Cumulative Sum of Divisors

LL sum(LL n)
{
    return (n*(n+1))/2;
}

LL CSOD(LL num)
{
    LL ans=0;
    LL nod=0;
    LL u=sqrt(num);

    for(LL i=2;i<=u;i++)
    {
        nod = (num/i)-i;
        ans += nod*i;
        ans += (sum(num/i)-sum(i));
        ans += i;

        //cout<<"ans "<<ans<<endl;
    }

    //nod *= 2;
    //nod +=u;
    //ans +=

    return ans;
}

//

int one_digit_sum(int n)
{
    while(n/10)
    {
        n=n/10+n%10;
    }
    return n;
}

//Find all permutation of a string

void all_perm(string str,int lim)
{
    int cnt=1;

    do
    {
        cout<<str<<endl;
        cnt++;
        if(cnt>lim)
            break;

    }while(next_permutation(str.begin(),str.end()));

}

int main()
{
    string ALP="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int tc;
    scanf("%d",&tc);

    for(int i=1;i<=tc;i++)
    {
        printf("Case %d:\n",i);
        int n,k;
        scanf("%d %d",&n,&k);
        all_perm(ALP.substr(0,n),k);

    }


    return 0;
}

//Dijkstra

#define MAX 100010
//#define INF INT_MAX// or use const int
const int INF = INT_MAX;
const LL LINF = LLONG_MAX;

int n,m;

vector<PII>adj[MAX];//distance,node
LL dist[MAX];
//bool visited[MAX];
int parent[MAX];

void dijkstra(int par)//parent
{
    //cout<<"sada"<<endl;

    fill(dist,dist+n+1,LINF);

    priority_queue< PII,vector<PII>,greater<PII> >PQ;
    //memset(visited,0,sizeof(visited));

    //visited[par] = true;
    dist[par] = 0;
    parent[par] = 1;
    PQ.push(MP(dist[par],par));

    while(!PQ.empty())
    {
        int now = PQ.top().second; //not front()
        PQ.pop();

        for(int i=0; i<adj[now].size(); i++)
        {
            int next = adj[now][i].first;
            int ed = adj[now][i].second; //edge distance

            //cout<<"**"<<now<<" "<<next<<" "<<ed<<endl;

            if(dist[now]+ed < dist[next])
            {
                dist[next] = dist[now]+ed;
                parent[next] = now;
                PQ.push(MP(dist[next],next));
            }


        }
        //cout<<"sada"<<endl;
    }


}

void solve()
{
    //cout<<"sada"<<endl;

    if(dist[n]==LINF)
    {
        printf("-1\n");
        return;

    }

    vector<int>path;
    int node = n;
    while(node!=1)
    {
        path.PUB(node);
        node = parent[node];

    }

    printf("1 ");

    for(int q=path.size()-1;q>=0;q--)
        printf("%d ",path[q]);

}

int main()
{
    SI(n),SI(m);
     int a,b,weight;

    fr(i,1,m)
    {

        SI(a),SI(b),SI(weight);

        adj[a].PUB(MP(b,weight));
        adj[b].PUB(MP(a,weight));
    }

    dijkstra(1);
    solve();

    return 0;
}

//Diameter of a tree

/*

Type : Graph/BFS/DFS

Lesson : How to find a diameter of a tree and use that idea to solve maximum distance from every nodes :v

*/

/*Which of the favors of your Lord will you deny ?*/

#include<bits/stdc++.h>
using namespace std;

#define LL  long long
#define PII pair<int,int>
#define PIL pair<int,LL>

#define MP  make_pair

vector<PII>adj[30010];
bool visited[30010];
LL dist1[30010];
LL dist2[30010];

void init()
{
    for(int i=0;i<=30005;i++)
        adj[i].clear();
}


PIL bfs(int node,int node_num)
{
    fill(visited,visited+30010,0);
    fill(dist1,dist1+30010,0);

    dist1[node]=0;
    queue<int>Q;
    Q.push(node);

    while(!Q.empty())
    {
        int now = Q.front();
        visited[now]=true;
        Q.pop();

        for(int i=0;i<adj[now].size();i++)
        {
            int next = adj[now][i].first;
            if(visited[next])
                continue;
            int ed = adj[now][i].second;

            visited[next]=true;
            dist1[next]=dist1[now]+ed;

            Q.push(next);
        }
    }

    LL max_dist=-1;
    int max_dist_node=-1;

    for(int i=0;i<node_num;i++)
    {
        //cout<<dist[i]<<endl;

        if(dist1[i]>max_dist)
        {
            max_dist=dist1[i];
            max_dist_node=i;
        }
    }

    return MP(max_dist_node,max_dist);
}

void bfs2(int node,int node_num)
{
    fill(visited,visited+30010,0);
    fill(dist2,dist2+30010,0);

    dist2[node]=0;
    queue<int>Q;
    Q.push(node);

    while(!Q.empty())
    {
        int now = Q.front();
        visited[now]=true;
        Q.pop();

        for(int i=0;i<adj[now].size();i++)
        {
            int next = adj[now][i].first;
            if(visited[next])
                continue;
            int ed = adj[now][i].second;

            visited[next]=true;
            dist2[next]=dist2[now]+ed;

            Q.push(next);
        }
    }

}

int main()
{
    int tc;
    scanf("%d",&tc);

    for(int q=1;q<=tc;q++)
    {
        init();

        int node_num,a,b,w;
        scanf("%d",&node_num);

        for(int i=1;i<=node_num-1;i++)
        {
            scanf("%d %d %d",&a,&b,&w);
            adj[a].push_back(MP(b,w));
            adj[b].push_back(MP(a,w));
        }

        PIL step1,step2;

        step1=bfs(0,node_num);
        step2=bfs(step1.first,node_num);
        bfs2(step2.first,node_num);

        //cout<<step2.first<<" "<<step2.second<<endl;

        //printf("Case %d: %lld\n",q,step2.second);
        printf("Case %d:\n",q);
        for(int i=0;i<node_num;i++)
        {
            LL ans=max(dist1[i],dist2[i]);
            printf("%lld\n",ans);

        }

    }


    return 0;
}

//RMQ


/* Which of the favors of your lord will you deny  ? */

#include<bits/stdc++.h>
using namespace std;

int ara[100010];
int tree[400040];

void build(int node,int start,int end)
{
    if(start==end)
    {
        tree[node]=ara[start];
        return;
    }

    int lc = 2*node , rc = 2*node+1;
    int mid = (start+end)/2;

    build(lc,start,mid);
    build(rc,mid+1,end);

    if(tree[lc]<tree[rc])
        tree[node]=tree[lc];
    else
        tree[node]=tree[rc];

}

int RMinQ(int node,int start,int end,int l,int r)
{
    if(l>end || r<start)
        return INT_MAX;

    if(start>=l && end<=r)
        return tree[node];

    int lc = 2*node , rc = 2*node+1;
    int mid = (start+end)/2;

    int lq = RMinQ(lc,start,mid,l,r); //left query
    int rq = RMinQ(rc,mid+1,end,l,r);

    if(lq<rq)
        return lq;
    else
        return rq;

}

int main()
{
    int tc;
    scanf("%d",&tc);

    for(int i=1;i<=tc;i++)
    {
        int n,q;
        scanf("%d %d",&n,&q);

        for(int j=1;j<=n;j++)
            scanf("%d",&ara[j]);

        printf("Case %d:\n",i);

        build(1,1,n);

        //cout<<"asdasdj"<<endl;

        int l,r;

        for(int w=1;w<=q;w++)
        {
            scanf("%d %d",&l,&r);
            int minn = RMinQ(1,1,n,l,r);
            printf("%d\n",minn);
        }

    }

    return 0;
}

//A good use of map

/*Which of the favors of your Lord will you deny ?*/

#include<bits/stdc++.h>
using namespace std;

#define LL long long
#define PII pair<int,int>
#define MP make_pair

vector<int>myf;
//vector<int>adj[10010];
map< int,vector<int> >MAP;

int main()
{
    int n,my_f_id,num,x;
    scanf("%d",&n);

    for(int i=1;i<=n;i++)
    {
        scanf("%d",&my_f_id);
        myf.push_back(my_f_id);

        scanf("%d",&num);

        for(int j=1;j<=num;j++)
        {
            scanf("%d",&x);
            MAP[my_f_id].push_back(x);
            //adj[my_f_id].push_back(x);
        }
    }

    set<int>s;

    for(int f:myf)
    {
        for(int it:MAP[f])
        {
            if(find(myf.begin(),myf.end(),it)!=myf.end())
                continue;
            else
                s.insert(it);
        }
    }

    cout<<s.size()<<endl;

    return 0;
}

int main()
{

    return 0;
}
