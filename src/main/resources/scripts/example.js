//@GuiCreate()
key = "example"
//快速导入所需模块
require([
    "TextModule.js"
])

function setting(Data) {
    new TextButton("test")
        .setX(10)
        .setY(10)
        .setTexts([
            "text",
            "what can i see",
            "小南娘大鸡鸡"
        ])
        .setWidth(10)
        .setHeight(10)
        .filter((value) =>{
            //如果是小南娘大鸡鸡就自动过滤
            value !== "小南娘大鸡鸡"
        })
        .builder(Data)
    return data
}
function buttonClick(data,buttonModule,button,action) {
    //快速注册一个按钮处理器
    Functions.ButtonModule.buttonHandler(map,data,buttonModule,button,action)
}
function opening(data) {
    customEvent("Opening").call()
}
function close(data) {
}
function checkClick(data,checkModule,button,action) {
}
function rangeClick(data,rangeModule,button,action) {
}
function selectClick(data,selectModule,button,action) {
}
function slotClick(data,slotModule,button,action) {
}
function input(data,inputModule) {
}
function chatInput(data,inputModule) {
}
function arealInput(data,areaInputModule) {
}
function keyPress(data,keyID,keyName) {
}
function keyOn(data,keyID,keyName) {
}
function keyOff(data,keyID,keyName) {
}
function enterText(data,inputChar) {
}