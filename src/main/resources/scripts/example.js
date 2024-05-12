//@GuiCreate()
key = "example"

load("plugins/UISystem/scripts/libs/TextModule.js")
load("plugins/UISystem/scripts/libs/ButtonModule.js")
load("plugins/UISystem/scripts/libs/Gui/Setting.js")


function setting(Data) {
    print(Data.player)
    const player = Data.player
    new MainGuiData(key)
        .setX()
        .setY()
        .setImage()
        .setHeight()
        .setWidth()
        .setPosition()
        .setTransparent()
        .addModuleData(()=>{
            return new TextModule("test")
                .setX(5)
                .setY(40)
                .setWidth(10)
                .setHeight(10)
                .setSpace(18)
                .addText(player.name)
        })
        .toUnrealCore()
}
function buttonClick(data,buttonModule,button,action) {
    Button.CreateHandler(data,buttonModule,button,action)
}
function opening(data) {
    if(data.player.name === "MinecraftMryely") {
        setDataValue(data)
    }

}

function setDataValue(data, key, value) {
    data.customData.put(key,value)
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