//@GuiCreate()
const MainGuiData = find("com.daxton.unrealcore.display.been.gui.MainGUIData")

/*
* 最简单的gui插件,也是最全能的gui插件
*
* Width这些都是字符串是因为要发给客户端，给客户端计算，减少服务器负担
*
* */


/*
*错误的做法：这会报错
*
* setting = ()=>{
    const data = new MainGuiData()
    data.setModuleID("example")
    data.setY("0")
    data.setX("0")
    data.setPosition("5")
    data.setImage("gui/background/background_2.png")
    const a = Math.random().toString()
    data.setWidth("250" + a)
    data.setHeight("250")
    data.setMask("true")
    data.setColor = "ffffff"
    data.transparent = "255"
    return data
    }
*
* */
const data = new MainGuiData()
data.setModuleID("example")
data.setY("0")
data.setX("0")
data.setPosition("5")
data.setImage("gui/background/background_2.png")
//一个简单的计算
const a = Math.random().toString()
data.setWidth("250" + a)

data.setHeight("250")
data.setMask("true")
data.setColor = "ffffff"
data.transparent = "255"
//这两个是必要的
key = "example"
setting = data

function opening(data) {
    print(data)
}
function close(data) {
    print(data)
}
