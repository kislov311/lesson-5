public class HomeWork5 {

    private static final int size = 10000000;
    private static final int h = size / 2;

    public float[] array(float[] arr){
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }



    public void method_1() {

        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        array(arr);
        System.out.println(System.currentTimeMillis() - a);
        }


    public void method_2 () {

        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1.0f;
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, 0, arr2, 0, h);

        new Thread(() -> {
            float[] a1 = array(arr1);
            System.arraycopy(a1, 0, arr1, 0, a1.length);
        }).start();

        new Thread(() -> {
            float[] a2 = array(arr2);
            System.arraycopy(a2, 0, arr2, 0, a2.length);
        }).start();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);
        }


    public static void main(String[] args) {
        HomeWork5 o = new HomeWork5();
        o.method_1();
        o.method_2();

    }
}
