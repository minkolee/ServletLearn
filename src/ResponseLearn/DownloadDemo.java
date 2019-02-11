package ResponseLearn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class DownloadDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 下载文件,其原理和复制文件一样,就是将文件的内容写入Response的流中
        //这里要注意的是,获取文件对象的方式要采用全局Web对象获取资源地址的方式,而写入流以后,需要设置HTTP的头部,才能让浏览器开始下载内容


        // 设置 Header
        // 要让浏览器下载,必须设置两个头部信息,第一个是这个文件的类型,第二个是文件名称和打开方式,告诉浏览器以下载的方式打开,注意,这必须在写入流之前进行设置


        String filename = "美女.zip";

        System.out.println(getServletContext().getMimeType("a.zip"));
        resp.setContentType(getServletContext().getMimeType("a.zip"));


        //如果文件名是中文或者其他字符,还需要将字符串设置为对应的编码格式
        // 主要是通过浏览器的信息进行判断,火狐竟然是Base64编码,其他浏览器都是UTF-8编码
        String agent = req.getHeader("User-Agent");
        System.out.println(agent);

        filename = URLEncoder.encode(filename, "UTF-8");
        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);




        //1 先找到需要下载的文件内容,获取字节流对象
        // 比如我们在web下边设置了download目录里的a.jpg文件供下载,先要获取路径

        String path = getServletContext().getRealPath("download/a.zip");

        System.out.println(path);

        // 2 获取字节流对象
        FileInputStream fis = new FileInputStream(path);

        // 3 获取Response对象的输出流
        OutputStream ops = resp.getOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = fis.read(buffer)) != -1) {
            ops.write(buffer, 0, len);
        }

        // 4 关闭读取文件的资源, response的输出流的对象会在响应方法执行完毕之后被关闭
        fis.close();
        // 5 结果这么做之后,浏览器直接显示了这幅图片,这是因为浏览器的请求头部已经写了默认会接受一些图片的格式,发过去的是jpg格式,就会被接受

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
