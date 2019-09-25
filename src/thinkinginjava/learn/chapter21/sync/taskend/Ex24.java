package thinkinginjava.learn.chapter21.sync.taskend;

/**
 * 解决带有缓冲区的单个生产者和消费者的问题
 * 初步想法是先随便弄一个数据对象
 * 然后弄一个缓冲区对象持有数据对象
 * 然后弄一个内部索引, 不断的循环取数据, 放数据的标记一旦到达长度就要wait(), 取数据取成0之后也要wait()
 */

public class Ex24 {
}
