# fo-ssm
### &emsp;&emsp;一个集成SpringMVC、Spring、Mybatis等框架的快速开发的项目，需要根据自己需要简单修改配置即可作为自己项目的开发基本架构。  


主要需要修改的地方为：<br/>


- 项目的包名，原包名为`com.panhainan`，修改成你的包名。
<br/>
由于项目包名在配置中需要使用，因此在spring-mvc.xml和applicationContext.xml里面的`context:component-scan` 需要将其中的包名改为你的包名；还有在`applicationContext.xml`里面的配置`mybatis`的注入`dao`接口配置处将包名修改。  

其他的根据自己的需要进行修改，比如数据库配置，日志配置等等

<br/>
<br/>
<br/>
部署配置过程中遇到问题可以联系作者，作者联系方式如下：<br/><br/>
<div style="background-color: #F3F3F3;
        width: 600px;
        padding: 20px 40px;">
    潘海南 <br/><br/>
    网站：<a href="http://www.panhainan.com" target="_blank">panhainan.com</a> <br/><br/>
    邮箱：panhainan@yeah.net <br/><br/>
    Q Q ：1016593477 <br/>
</div>


