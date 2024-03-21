package CodingTest.BaekJoon;

import java.io.*;
import java.util.*;
// 65760KB | 856ms
//[BOJ] 16935 배열돌리기3
public class B16935 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int rotation = Integer.parseInt(st.nextToken());
            if (rotation == 1) {
                arr = rotation1(arr);
            }
            if (rotation == 2) {
                arr = rotation2(arr);
            }
            if (rotation == 3) {
                arr = rotation3(arr);
                int temp = n;        //n,m바꾸기
                n = m;
                m = temp;
            }
            if (rotation == 4) {
                arr = rotation4(arr);
                int temp = n;
                n = m;
                m = temp;
            }
            if (rotation == 5) {
                arr = rotation5(arr);
            }
            if (rotation == 6) {
                arr = rotation6(arr);
            }

        }

        //출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    static int[][] rotation1(int[][] arr) {    //상하반전
        int[][] newArr = new int[n][m];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                newArr[i][j] = arr[n - 1 - i][j];
                newArr[n - 1 - i][j] = arr[i][j];
            }
        }

        return newArr;
    }

    static int[][] rotation2(int[][] arr) {    //좌우반전
        int[][] newArr = new int[n][m];
        for (int j = 0; j < m / 2; j++) {
            for (int i = 0; i < n; i++) {
                newArr[i][j] = arr[i][m - 1 - j];
                newArr[i][m - 1 - j] = arr[i][j];
            }
        }

        return newArr;
    }

    static int[][] rotation3(int[][] arr) {    //오른쪽으로 90도 회전
        int[][] newArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newArr[i][j] = arr[n - 1 - j][i];
            }
        }

        return newArr;
    }

    static int[][] rotation4(int[][] arr) {    //왼쪽으로 90도 회전
        int[][] newArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newArr[i][j] = arr[j][m - 1 - i];
            }
        }

        return newArr;
    }

    static int[][] rotation5(int[][] arr) {    // 부분 배열 시계방향 이동
        int[][] newArr = new int[n][m];
        //1번 그룹
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                newArr[i][j] = arr[i + n / 2][j];
            }
        }

        //2번 그룹
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                newArr[i][j] = arr[i][j - m / 2];
            }
        }

        //3번 그룹
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                newArr[i][j] = arr[i - n / 2][j];
            }
        }

        //4번 그룹
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                newArr[i][j] = arr[i][m / 2 + j];
            }
        }
        return newArr;
    }

    static int[][] rotation6(int[][] arr) {    // 부분 배열 반시계방향 이동
        int[][] newArr = new int[n][m];
        //1번 그룹
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                newArr[i][j] = arr[i][j + m / 2];
            }
        }

        //2번 그룹
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                newArr[i][j] = arr[i + n / 2][j];
            }
        }

        //3번 그룹
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                newArr[i][j] = arr[i][j - m / 2];
            }
        }

        //4번 그룹
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                newArr[i][j] = arr[i - n / 2][j];
            }
        }
        return newArr;
    }
}


