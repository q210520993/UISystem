load("plugins/UISystem/scripts/libs/TextModule.js")
//@HudCreate(test)
function test() {
    const a= new TextModule("test")
        .setX(5)
        .setY(40)
        .setWidth(10)
        .setHeight(10)
        .setSpace(18)
        .addText("我是男娘")
        .toJavaModule()
    return listOf([a])
}