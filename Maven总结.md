## 1、maven的用途

​		maven是一个项目构建和管理的工具，提供了帮助管理 构建、文档、报告、依赖、scms、发布、分发的方法。可以方便的编译代码、进行依赖管理、管理二进制库等等。

​		maven的好处在于可以将项目过程规范化、自动化、高效化以及强大的可扩展性。

​		利用maven自身及其插件还可以获得代码检查报告、单元测试覆盖率、实现持续集成等等。

## 2、maven的核心概念介绍

### 2.1 Pom

​		pom是指project object Model。pom是一个xml，在maven2里为[pom.xml](http://maven.apache.org/guides/introduction/introduction-to-the-pom.html)。是maven工作的基础，在执行task或者goal时，maven会去项目根目录下读取pom.xml获得需要的配置信息。

​		pom文件中包含了项目的信息和maven build项目所需的配置信息，通常有项目信息(如版本、成员)、项目的依赖、插件和goal、build选项等等。

​		pom是可以继承的，通常对于一个大型的项目或是多个module的情况，子模块的pom需要指定父模块的pom。

​		pom文件中节点为

![img](file:///C:/Users/ADMINI~1/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg)

**project** pom文件的顶级元素 

**modelVersion** 所使用的object model版本，为了确保稳定的使用，这个元素是强制性的。除非maven开发者升级模板，否则不需要修改 

**groupId** 是项目创建团体或组织的唯一标志符，通常是域名倒写，如groupId org.apache.maven.plugins就是为所有maven插件预留的 

**artifactId** 是项目artifact唯一的基地址名 

**packaging** artifact打包的方式，如jar、war、ear等等。默认为jar。这个不仅表示项目最终产生何种后缀的文件，也表示build过程使用什么样的

`&lt;a href="http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#Built-in_Lifecycle_Bindings" target="_blank">lifecycle</a>。`  

**version** artifact的版本，通常能看见为类似0.0.1-SNAPSHOT，其中SNAPSHOT表示项目开发中，为开发版本 

**name** 表示项目的展现名，在maven生成的文档中使用 

**url**表示项目的地址，在maven生成的文档中使用 

**description** 表示项目的描述，在maven生成的文档中使用 

**dependencies** 表示依赖，在子节点dependencies中添加具体依赖的groupId artifactId和version 

**build** 表示build配置 

**parent** 表示父pom 

其中groupId:artifactId:version唯一确定了一个artifact

### 2.2 Artifact

​		这个有点不好解释，大致说就是一个项目将要产生的文件，可以是jar文件，源文件，二进制文件，war文件，甚至是pom文件。每个artifact都由groupId:artifactId:version组成的标识符唯一识别。需要被使用(依赖)的artifact都要放在仓库(见Repository)中。

### 2.3 Repositories

​		Repositories是用来存储Artifact的。如果说我们的项目产生的Artifact是一个个小工具，那么Repositories就是一个仓库，里面有我们自己创建的工具，也可以储存别人造的工具，我们在项目中需要使用某种工具时，在pom中声明dependency，编译代码时就会根据dependency去下载工具（Artifact），供自己使用。

​		对于自己的项目完成后可以通过mvn install命令将项目放到仓库（Repositories）中，仓库分为本地仓库和远程仓库，远程仓库是指远程服务器上用于存储Artifact的仓库，本地仓库是指本机存储Artifact的仓库，对于windows机器本地仓库地址为系统用户的.m2/repository下面。

​		对于需要的依赖，在pom中添加dependency即可，可以在maven的仓库中搜索：http://mvnrepository.com/

### 2.4 Build Lifecycle

​		是指一个项目build的过程。maven的Build Lifecycle分为三种，分别为default（处理项目的部署）、clean（处理项目的清理）、site（处理项目的文档生成）。他们都包含不同的[lifecycle](http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#Lifecycle_Reference)。

​		Build Lifecycle是由phases构成的，下面重点介绍default Build Lifecycle几个重要的phase

**validate** 验证项目是否正确以及必须的信息是否可用 

**compile** 编译源代码 

**test** 测试编译后的代码，即执行单元测试代码 

**package** 打包编译后的代码，在target目录下生成package文件 

**integration-test** 处理package以便需要时可以部署到集成测试环境 

**verify** 检验package是否有效并且达到质量标准 

**instal**l 安装package到本地仓库，方便本地其它项目使用 

**deploy** 部署，拷贝最终的package到远程仓库和替他开发这或项目共享，在集成或发布环境完成  

​		以上的phase是有序的（注意实际两个相邻phase之间还有其他phase被省略，完整phase见[lifecycle](http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#Lifecycle_Reference)），下面一个phase的执行必须在上一个phase完成后

​		若直接以某一个phase为goal，将先执行完它之前的phase，如mvn install，将会先validate、compile、test、package、integration-test、verify最后再执行install phase。

### 2.5 Goal

​		goal代表一个特定任务A goal represents a specific task (finer than a build phase) which contributes to the building and managing of a project. 如

**mvn package**表示打包的任务，通过上面的介绍我们知道，这个任务的执行会先执行package phase之前的phase

**mvn deploy**表示部署的任务

**mven clean install**则表示先执行clean的phase（包含其他子phase），再执行install的phase。