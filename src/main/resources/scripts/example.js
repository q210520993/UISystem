//@GuiCreate()
key = "example"
load("plugins/UISystem/libs/customEvent.js")
load("plugins/UISystem/libs/Modules.js")
const map = new java.util.HashMap()
const button1 = (()=>{
    const button = new ModulesAPI.Button()
    button.moduleID = "button"
    button.x = -3
    button.y = 3
    button.image = "gui/icon/x.png"
    button.color = "#FFFFFF"
    button.hoverColor = "#1e90ff"
    button.clickColor = button.hoverColor
    button.transparent = 255
    button.width = 6
    button.height = 6
    button.textColor = "#00CACA"
    button.textSize = 1
    return button
})()
function setting(guidata) {
    const data = guidata.getMainGuiData()
    data.setModuleID("example")
    data.setY("0")
    data.setX("0")
    data.setPosition("5")
    data.setImage("gui/background/background_2.png")
    data.setHeight("250")
    data.setMask("true")
    data.setColor = "ffffff"
    data.transparent = "255"
    data.addModule("button", button1)
    data.setWidth(250)
    return data
}
function opening(data) {
    customEvent("InvOpening").call()
}
function close(data) {
}
map.put("button", (data) =>{
    const a = data.player
    a.sendMessage("hello,Button")
})
function buttonClick(data,buttonModule,button,action) {
    map.get(buttonModule.moduleID)(data)
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