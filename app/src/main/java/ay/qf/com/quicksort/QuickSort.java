package ay.qf.com.quicksort;

/**
 * Created by ASUS on 2016/11/10.
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] list={34,3,53,2,23,7,14,10};
        QuickSort qs= new QuickSort();
        qs.quick(list);
        for( int i=0;i<list. length;i++){
            System. out.print(list[i]+ " ");
        }
        System. out.println();

    }
    public void quick(Integer[] str) {
        if (str.length > 0) {    //查看数组是否为空
            _quickSort(str, 0, str. length - 1);  //从第一个数到最后一个数
        }
    }

    public void _quickSort(Integer[] list, int low, int high) { //low，最小索引，high最高索引
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二 ,取得中间值对应的索引
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    //获得数组的中间值的索引（即位置）(参数：数组，最低索引，最高索引)
    public int getMiddle(Integer[] list, int low, int high) {
        int tmp = list[low];    //先用数组的第一个值作为中轴(对比值)
        while (low < high) {
            //后一半的数组，把中值与最后一个比，如果不比它大则不交换则再与前一个再比
            while (low < high && list[high] > tmp) {
                high--;
            }
            list[low] = list[high];   //最后list[high]小于对比值时,则把这个值移到低端------------>这里list[low]值发生了改变 ,为下面循环作准备

            while (low < high && list[low] < tmp) { //前一半，中值与低端值比，如果比中值小则与下一个数比
                low++; //修改索引为下一个数
            }
            list[high] = list[low];   //否则，如果list[low]比中轴大，则把这个值移到高端------------->这里list[high]值发生了改变
        }

        list[low] = tmp; //上面循环处理完后，把当前中轴值存到当前数组的低端（其实当前的low在上面处理完后，已逐渐修改为中间的索引）
        System.out.println(low +"============"+tmp);
        return low;                   //返回中轴的位置
    }
}
