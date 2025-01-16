package CodingTest.BaekJoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
[BOJ] 16935 배열돌리기 3
60796KB |	408ms
[문제 풀이 - 최적화]
16428KB |	272ms
1. 1번 연산(상하 반전) 시, 1차원 배열 자체를 교환한다.
2. 3,4,5,6번 연산 시, 매번 N*M(or M*N) 크기의 배열을 만들지 않게 static int[][] 선언 후 참조만 변경
 => 크기는 3,4번 연산 시 변경될 수 있으므로 가장 큰 값으로 만들기
3. 5,6번 연산은 작은 사각형만큼 있던 for문을 하나의 for문으로 통합할 수 있다.
=> 작은 사각형 그룹은 모두 크기가 0 ~ N/2, 0 ~ M/2 로 동일하므로 이걸 기준으로 삼아 for문을 돌린다.
 */
public class B16935_배열돌리기3 {
    static int N;   //배열의 크기
    static int M;
    static int R;   // 연산의 수
    static int[][] arr;
    static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int size = Math.max(N,M);

        //  3,4번에 의한 회전 시에도 사용 가능하도로 N,M 중 큰 값으로 행열 크기 만들기
        arr = new int[size][size];
        temp = new int[size][size];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로직
        st = new StringTokenizer(br.readLine());
        for(int r = 0; r < R; r++){
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) upDown();
            if(num == 2) leftRight();
            if(num == 3) right90();
            if(num == 4) left90();
            if(num == 5) rotate5();
            if(num == 6) rotate6();
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    // 1번 연산 : 상하 반전
    static void upDown(){
//        for(int i = 0; i < N/2; i++){
//            for(int j = 0; j < M; j++){
//                int temp = arr[i][j];
//                arr[i][j] = arr[N-i-1][j];
//                arr[N-i-1][j] = temp;
//            }
//        }
        // 1차원 배열 자체를 교환
        for(int r1 = 0, r2 = N-1; r1 < r2; r1++, r2--){
            int[] temp = arr[r1];
            arr[r1] = arr[r2];
            arr[r2] = temp;
        }
    }

    //2번 연산 : 좌우 반전
    static void leftRight(){
        for(int j = 0; j < M/2; j++){
            for(int i = 0; i < N; i++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][M-1-j];
                arr[i][M-1-j] = temp;
            }
        }

    }

    //3번 연산 : 오른쪽 90도 회전
    static void right90(){
//        // 배열 복사
//        int[][] temp = copyArr();
//        arr = new int[M][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                temp[j][N-1-i] = arr[i][j];
            }
        }
        // 참조만 변경함으로써 배열을 새로 만들 필요 없어짐
        int[][] t = arr;
        arr = temp; //업데이트한 배열을 arr이 참조하게
        temp = t;   //temp배열은 뒤죽박죽된 arr배열이었던 것을 참조

        // N,M 바꾸기
        int tmp = N;
        N = M;
        M = tmp;

    }

    // 4번 연산 : 왼쪽으로 90도
    static void left90(){
//        // 배열 복사
//        int[][] temp = copyArr();
//        arr = new int[M][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                temp[M-1-j][i] = arr[i][j];
            }
        }
        int[][] t = arr;
        arr = temp;
        temp = t;

        // N,M 바꾸기
        int tmp = N;
        N = M;
        M = tmp;

    }

    // 5번 연산 : 그룹 시계방향 이동
    static void rotate5(){
        //[for문 통합]
        // 작은 사각형 그룹은 모두 크기가 0 ~ N/2, 0 ~ M/2 로 동일하므로
        // 이걸 기준으로 삼아 for문을 돌린다.

        for(int r = 0; r < N/2; r++){
            for(int c = 0; c < M/2; c++){
                int temp = arr[r][c];   //1번 이전 값 저장

                // 4번 -> 1번
                arr[r][c] = arr[r + N/2][c];
                // 3번 -> 4번
                arr[r+N/2][c] = arr[r+N/2][c+M/2];
                // 2번 -> 3번
                arr[r+N/2][c+M/2] = arr[r][c+M/2];
                // 1번 -> 2번
                arr[r][c+M/2] = temp;

            }
        }

//        //배열 복사
//        int[][] temp = copyArr();
//        // 1번 -> 2번
//        for(int i = 0; i < N/2; i++){
//            for(int j = 0; j < M/2; j++){
//                arr[i][j+M/2] = temp[i][j];
//            }
//        }
//
//        // 2번 -> 3번
//        for(int i = 0; i < N/2; i++){
//            for(int j = M/2; j < M; j++){
//                arr[i+N/2][j] = temp[i][j];
//            }
//        }
//
//        // 3번 -> 4번
//        for(int i = N/2; i < N; i++){
//            for(int j = M/2; j < M; j++){
//                arr[i][j-M/2] = temp[i][j];
//            }
//        }
//
//        // 4번 -> 1번
//        for(int i = N/2; i < N; i++){
//            for(int j = 0; j < M/2; j++){
//                arr[i-N/2][j] = temp[i][j];
//            }
//        }
    }

    // 6번 연산 : 그룹 반시계 방향 이동
    static void rotate6(){
        for(int r = 0; r < N/2; r++){
            for(int c = 0; c < M/2; c++){
                int temp = arr[r][c];

                // 2번 -> 1번
                arr[r][c] = arr[r][c+M/2];
                //3번 -> 2번
                arr[r][c+M/2] = arr[r+N/2][c+M/2];
                //4번 -> 3번
                arr[r+N/2][c+M/2] = arr[r+N/2][c];
                // 1번 -> 4번
                arr[r+N/2][c] = temp;
            }
        }
//        int[][] temp = copyArr();
//
//        // 1번 -> 4번
//        for(int i = 0; i < N/2; i++){
//            for(int j = 0; j < M/2; j++){
//                arr[i+N/2][j] = temp[i][j];
//            }
//        }
//
//        // 4번 -> 3번
//        for(int i = N/2; i < N; i++){
//            for(int j = 0; j < M/2; j++){
//                arr[i][j + M/2] = temp[i][j];
//            }
//        }
//
//        // 3번 -> 2번
//        for(int i = N/2; i < N; i++){
//            for(int j = M/2; j < M; j++){
//                arr[i-N/2][j] = temp[i][j];
//            }
//        }
//
//        //2번 -> 1번
//        for(int i = 0; i < N/2; i++){
//            for(int j = M/2; j < M; j++){
//                arr[i][j-M/2] = temp[i][j];
//            }
//        }
    }


    static int[][] copyArr(){
        int[][] temp = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

}
