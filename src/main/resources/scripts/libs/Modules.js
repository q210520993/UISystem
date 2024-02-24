load("plugins/Pouvoir/scripts/core/basic.js");

const ModulesAPI = {
    Button: find("com.daxton.unrealcore.display.been.module.control.ButtonModuleData"),
    ChatDisplay: find("com.daxton.unrealcore.display.been.module.control.ChatDisplayModuleData"),
    CheckModuleData: find("com.daxton.unrealcore.display.been.module.control.CheckModuleData"),
    ContainerModule: find("com.daxton.unrealcore.display.been.module.control.ContainerModuleData"),
    ContainerModuleDataStaring: find("com.daxton.unrealcore.display.been.module.control.ContainerModuleDataStaring"),
    RangeModule: find("com.daxton.unrealcore.display.been.module.control.RangeModuleData"),
    SelectModule: find("com.daxton.unrealcore.display.been.module.control.SelectModuleData"),
    SlotModule: find("com.daxton.unrealcore.display.been.module.control.SlotModuleData"),
    EntityModule: find("com.daxton.unrealcore.display.been.module.display.EntityModuleData"),
    HotSlotModule: find("com.daxton.unrealcore.display.been.module.display.HotSlotModuleData"),
    ImageModuleData: find("com.daxton.unrealcore.display.been.module.display.ImageModuleData"),
    ItemModuleData: find("com.daxton.unrealcore.display.been.module.display.ItemModuleData"),
    ProgressModule: find("com.daxton.unrealcore.display.been.module.display.ProgressModuleData"),
    TextModule: find("com.daxton.unrealcore.display.been.module.display.TextModuleData"),
    AreaInputModule: find("com.daxton.unrealcore.display.been.module.input.AreaInputModuleData"),
    ChatInputModule: find("com.daxton.unrealcore.display.been.module.input.ChatInputModuleData"),
    InputModule: find("com.daxton.unrealcore.display.been.module.input.InputModuleData")
}


const Functions = {
    MainGuiData: {
        instance: (data,key,unit) => {
            const Data = data.getMainGUIData()
            data.setModuleID(key)
            unit.call(Data)
            return Data
        }
    },
    ButtonModule: {
        //快速建立一个Button
        instance: (data,key,unit)=>{
            const button = new ModulesAPI.Button()
            button.moduleID = key
            unit.call(button)
            data.addModule(key, button)
            return button
        },
        //快速向按钮组件中注册一个按钮
        createBlock: (data,button,map,unit) =>{
            const butt = find("com.daxton.unrealcore.display.content.module.control.ButtonModule")
            data.moduleComponentsMap.put(button.moduleID, new butt(button))
            map.put(button.moduleID,unit)
        },
        removeBlock: (map,key) =>{
            map.remove(key)
        },
        //快速注册一个按钮处理器
        buttonHandler: (map,data,buttonModule,button,action)=>{
            if(map.get(buttonModule.moduleID) == null) return
            map.get(buttonModule.moduleID)(data,buttonModule,button,action)
        }
    },
    ImageModule: {
        instance: (data,key,unit)=>{
            const module = new ModulesAPI.ImageModuleData()
            module.moduleID = key
            unit.call(module)
            data.addModule(key, button)
            return module
        },
        addImage: (image) =>{
            let i = 1
            for(i; i < arguments.length; i++){
                image.addImage(arguments[i])
            }
        }
    }
}
//链式的实现，有需要的自己写吧，太麻烦了，以下是例子
// const ButtonModuleTest = (() => {
//     function Wrapper(data, key) {
//         this.buttonConfig = {
//             x: -3,
//             y: 3,
//             image: '',
//             color: '#FFFFFF',
//         }
//         this.data = data
//         this.key = key
//         this.setImage = function(image) {
//             this.buttonConfig.image = image
//             return this
//         }
//
//         this.setColor = (color) => {
//             this.buttonConfig.color = color
//             return this
//         }
//
//         this.create = () => {
//             const buttonModule = Functions.ButtonModule.instance(this.data, this.key, () => {
//                 const button = new ModulesAPI.Button()
//                 this.buttonConfig.forEach((key,value)=>{
//                     button.key = value
//                 })
//                 return button
//             })
//             this.data.mainGuiData.addModule("button", buttonModule)
//
//             return buttonModule
//         }
//     }
//     return Wrapper
// })()
//注册是这样
// const button = new ButtonModuleTest(data, "button1")
//     .setImage("gui/icon/x.png")
//     .setColor("#FFFFFF")
//     .create()