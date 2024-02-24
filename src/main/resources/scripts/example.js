//@GuiCreate()
load("plugins/UISystem/scripts/libs/Modules.js");
load("plugins/UISystem/scripts/libs/customValue.js");
key = "example"
const map = new java.util.HashMap()
const MouseActionType = find("com.daxton.unrealcore.common.type.MouseActionType")
const MouseButtonType = find("com.daxton.unrealcore.common.type.MouseButtonType")
function setting(guidata) {
    //快速注册主要数据                                   界面数据       主要数据的ID，通常和界面数据一样
    const mainGuiData = Functions.MainGuiData.instance(guidata,"example",()=>{
        this.y = 0
        this.x = 0
        this.position = 5
        this.image = "gui/background/background_2.png"
        this.height = 250
        this.width = 250
        this.mask = true
        this.setColor = "ffffff"
        this.transparent = "255"
    })
    //快速注册按钮图标                              主要数据         moduleID(在这个主要数据里无法重复)
    const test = Functions.ButtonModule.instance(mainGuiData,"button1",()=>{
        this.x = -3
        this.y = 3
        this.image = "gui/icon/x.png"
        this.color = "#FFFFFF"
        this.hoverImage = "gui/icon/x.png"
        this.hoverColor = "#1e90ff"
        this.clickColor = "#1e90ff"
        this.position = 3
        this.font = "0"
        this.transparent = 255
        this.width = 6
        this.height = 6
        this.textColor = "#00CACA"
        this.textSize = 1
        this.use = true
    })
    //快速注册按钮触发器
    Functions.ButtonModule.createBlock(guidata,test,map,(data,buttonModule,button,action) =>{
        //BLOCK
        if(button === MouseButtonType.Left && action === MouseActionType.Off) {
        }
    })
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