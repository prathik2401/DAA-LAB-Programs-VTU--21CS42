package lab.cse;
import java.util.*;
public class DijkstrasAlgoritm {
	static void shortest(int startingVertex, int cost[][], int dist[], int TotalNumberOfVertices) {
		boolean [] S = new boolean [10];
		int i, w, u, numberOfVerticesVisited;
		for(i=1;i<=TotalNumberOfVertices;i++) {
			S[i] = false;
			dist[i] = cost[startingVertex][i];
		}
		S[startingVertex] = true;
		dist[startingVertex] = 0;
		numberOfVerticesVisited = 2;
		while(numberOfVerticesVisited <= TotalNumberOfVertices) {
			u = choose(dist, S, TotalNumberOfVertices);
			S[u] = true;
			numberOfVerticesVisited++;
			for(w=1;w<=TotalNumberOfVertices;w++) {
				if(((dist[u]+cost[u][w])<dist[w]) && ! S[w])
					dist[w] = dist[u]+cost[u][w];
			}
		}
	}
	private static int choose(int[] dist, boolean[] s, int n) {
		int w, j = 0, min = 9999;
		for(w=1;w<=n;w++)
			if((dist[w]<min)&& (s[w] == false)) {
				min = dist[w];
				j=w;
			}
		return j;
	}
	public static void main(String[] args) {
		int [][]cost = new int [50][50];
		int [] dist = new int [50];
		int i, j, n, v;
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the number of nodes : ");
		n = read.nextInt();
		System.out.println("Enter the cost adjacency matrix : ");
		for( i =1;i<=n;i++)
			for(j=1;j<=n;j++)
				cost[i][j] = read.nextInt();
		System.out.println("Enter the starting vertex : ");
		v= read.nextInt();
		shortest(v, cost, dist,n);
		System.out.println("Shortest path starting from vertex to other vertices are : ");
		for(j=1;j<=n;j++)
			System.out.println(v + " -> "+j+" = "+dist[j]);
		read.close();
		}
}
