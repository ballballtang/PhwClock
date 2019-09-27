# PhwClock

程序代码在src文件夹中，一共有四个类，CityClock表示酒店的城市时钟，PhoneClock表示手机时钟，TimeProcessor用来处理时间（获取UTC时间，和对时间进行加法运算），PhwClockUI用来启动程序

测试代码放在test文件夹下，对TimeProcessor 的addTime（增加时间）方法和PhwClockUI的changeTime（改变时间方法）进行了单元测试

其中测试了addTime的因时间格式不正确而引起的异常，已经是否正确进行了时间的小时数加减法，测试了changeTime是否对一些特殊的时间增加减少进行处理，比如北京 时间为零点时，伦敦的时间需要减去一天

该单元测试没有发现缺陷
