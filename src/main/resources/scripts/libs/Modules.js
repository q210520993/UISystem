// load("plugins/Pouvoir/scripts/core/basic.js")
//
//
// const Functions = {
//     MainGuiData: {
//         instance: (data,key,unit) => {
//             const Data = data.getMainGUIData()
//             data.setModuleID(key)
//             unit.call(Data)
//             return Data
//         }
//     },
//     ButtonModule: {
//         //快速建立一个Button
//         instance: (data,key,unit)=>{
//             const button = new ModulesAPI.Button()
//             button.moduleID = key
//             unit.call(button)
//             data.addModule(key, button)
//             return button
//         },
//         //快速向按钮组件中注册一个按钮
//         createBlock: (data,button,map,unit) =>{
//             const butt = find("com.daxton.unrealcore.display.content.module.control.ButtonModule")
//             data.moduleComponentsMap.put(button.moduleID, new butt(button))
//             map.put(button.moduleID,unit)
//         },
//         removeBlock: (map,key) =>{
//             map.remove(key)
//         },
//         //快速注册一个按钮处理器
//         buttonHandler: (map,data,buttonModule,button,action)=>{
//             if(map.get(buttonModule.moduleID) == null) return
//             map.get(buttonModule.moduleID)(data,buttonModule,button,action)
//         }
//     },
//     ImageModule: {
//         instance: (data,key,unit)=>{
//             const module = new ModulesAPI.ImageModuleData()
//             module.moduleID = key
//             unit.call(module)
//             data.addModule(key, button)
//             return module
//         },
//         addImage: (image) =>{
//             let i = 1
//             for(i; i < arguments.length; i++){
//                 image.addImage(arguments[i])
//             }
//         }
//     }
// }
//
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
//             this.image = image
//             return this
//         }
//
//         this.setColor = (color) => {
//             this.color = color
//             return this
//         }
//
//         this.create = () => {
//             const buttonModule = Functions.ButtonModule.instance(this.data, this.key, () => {
//                 const button = new ModulesAPI.Button()
//                 this.forEach((key,value)=>{
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
// //注册是这样
// // const button = new ButtonModuleTest(data, "button1")
// //     .setImage("gui/icon/x.png")
// //     .setColor("#FFFFFF")
// //     .create().
//
//
// const a = new TextButton("module").setX(123)
