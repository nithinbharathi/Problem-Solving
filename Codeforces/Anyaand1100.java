import java.util.*;
import java.io.*;

public class Problem {

    
	public static void main(String[] args) {
		 Template  t = new Template();
		 StringBuilder sb = new StringBuilder();	 
		 int test = t.readInt();
		 
		 
		 while(test-->0) {
			 char c[] = t.read().toCharArray();
			 int n = c.length;
			 int cnt = 0;
			 
			 for(int i  =0;i<n;i++) {
				 if(i+3<n && c[i] == '1' && c[i+1] == '1' && c[i+2] == '0' && c[i+3] == '0')
					 cnt++;
			 }
			 
			 int q = t.readInt();
			 while(q-->0) {
				 int ind = t.readInt()-1;
				 int val = t.readInt();
				 cnt = check(c,ind,cnt,-1);
				 c[ind] = (char)('0'+val);
				 cnt = check(c, ind, cnt, 1);

				 sb.append(cnt>0?"YES\n":"NO\n");
			 }
			 
			 
		 }
		 System.out.println(sb);
	}
	
	private static int check(char c[], int ind, int cnt, int val) {
		if(c[ind] == '0') {
			if(ind-2>=0 && ind+1< c.length && c[ind-1] =='1' && c[ind-2] == '1' && c[ind+1] == '0')
				cnt+=val;
			if(ind-3>=0 && c[ind-1] == '0' && c[ind-2] == '1' && c[ind-3] == '1')
				cnt+=val;
		}else {
			if(ind-1>=0 && ind+2<c.length && c[ind-1] == '1' && c[ind+1] == '0' && c[ind+2] == '0')
				cnt+=val;
			if(ind+3<c.length && c[ind+1] == '1' && c[ind+2] == '0' && c[ind+3] == '0')
				cnt+=val;
		}
		
		return cnt;
	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Template {
		private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		private StringTokenizer st;

		public int last(int a[], int target) {
			int ind = -1;
			int l = 0, r = a.length - 1;
			while (l <= r) {
				int mid = (l + r) / 2;
				if (a[mid] <= target) {
					ind = mid;
					l = mid + 1;
				} else
					r = mid - 1;
			}
			return ind;
		}

		public boolean isSorted(int a[]) {
			for (int i = 0; i < a.length; i++) {
				if (i + 1 < a.length && a[i] > a[i + 1])
					return false;
			}
			return true;
		}

		public boolean isPrime(int n) {
			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0)
					return false;
			}
			return true;
		}

		public long factorial(int n) {
			long fac = 1;
			for (int i = 1; i <= n; i++)
				fac *= i;
			return fac;
		}

		public ArrayList<Integer> factors(int n) {
			ArrayList<Integer> l = new ArrayList<>();
			for (int i = 1; i * i <= n; i++) {
				if (n % i == 0) {
					l.add(i);
					if (n / i != i)
						l.add(n / i);
				}

			}
			return l;
		}

		public void build(int seg[], int ind, int l, int r, int a[]) {
			if (l == r) {
				seg[ind] = a[l];
				return;
			}
			int mid = (l + r) / 2;
			build(seg, (2 * ind) + 1, l, mid, a);
			build(seg, (2 * ind) + 2, mid + 1, r, a);
			seg[ind] = Math.min(seg[(2 * ind) + 1], seg[(2 * ind) + 2]);
		}

		public long gcd(long a, long b) {
			return b == 0 ? a : gcd(b, a % b);
		}

		public int gcd(int a, int b) {
			return b == 0 ? a : gcd(b, a % b);
		}

		public void swap(int a[], int i, int j) {
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}

		public void swap(char a[], int i, int j) {
			char t = a[i];
			a[i] = a[j];
			a[j] = t;
		}

		public void swap(ArrayList<Integer> l, int i, int j) {
			int t = l.get(i);
			l.set(i, l.get(j));
			l.set(j, t);
		}

		public void sort(int arr[]) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int it : arr)
				list.add(it);
			Collections.sort(list);
			int z = 0;
			for (int i = 0; i < arr.length; i++)
				arr[z++] = list.get(i);
		}

		public void sort(char arr[]) {
			ArrayList<Character> list = new ArrayList<>();
			for (char it : arr)
				list.add(it);
			Collections.sort(list);
			int z = 0;
			for (int i = 0; i < arr.length; i++)
				arr[z++] = list.get(i);
		}

		public void sort(long arr[]) {
			ArrayList<Long> list = new ArrayList<>();
			for (long it : arr)
				list.add(it);
			Collections.sort(list);
			int z = 0;
			for (int i = 0; i < arr.length; i++)
				arr[z++] = list.get(i);
		}

		public String read() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int readInt() {
			return Integer.parseInt(read());
		}

		public long readLong() {
			return Long.parseLong(read());
		}

		public double readDouble() {
			return Double.parseDouble(read());
		}

	}

}
