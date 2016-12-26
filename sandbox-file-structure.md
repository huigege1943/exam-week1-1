# 应用沙盒文件结构
- /data/data/<app-package-name> 
- 在程式中用Context.openFileOutput() 所建立的档案，都放在这个目录下的files 子目录内。
- 而用Context.getSharedPreferences() 所建立的preferences 档(*.xml) ，则是放在shared_pref 这个子目录中。
- 资料查找不完全，待补充