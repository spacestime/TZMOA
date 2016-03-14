CKEDITOR.editorConfig = function( config ) 
{ 
// Define changes to default configuration here. For example: 
config.language = 'zh-cn'; //配置语言 
config.uiColor = 'FFFFFF'; //背景颜色 
//config.width = 600; //宽度 
//config.height = 200; //高度 
//皮肤
//config.skin = 'moono';
//config.skin = 'office2013';
//config.skin = 'moono-dark';
//config.skin = 'atlas';
//config.skin = 'bootstrapck';
//config.skin = 'kama';
//config.skin = 'moono_blue';
config.skin = 'moonocolor';

//工具栏 
config.toolbar_Basic =
[
   ['Bold','Italic','Underline'],
	['Link','Unlink'],
	['Image','Smiley','SpecialChar'],
	['FontName'],
	['FontSize'],
	['TextColor','BGColor'],
];

config.toolbar_Full =
[
    { name: 'document',    items : [ 'Source','-','Save','NewPage','DocProps','Preview','Print','-','Templates' ] },
    { name: 'clipboard',   items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
    { name: 'editing',     items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },
    { name: 'forms',       items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },
    '/',
    { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
    { name: 'paragraph',   items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
    { name: 'links',       items : [ 'Link','Unlink','Anchor' ] },
    { name: 'insert',      items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak' ] },
    '/',
    { name: 'styles',      items : [ 'Styles','Format','Font','FontSize' ] },
    { name: 'colors',      items : [ 'TextColor','BGColor' ] },
    { name: 'tools',       items : [ 'Maximize', 'ShowBlocks','-','About' ] }
];

config.toolbar_bbs	= 
[
	['NewPage','RemoveFormat'],
	['Bold','Italic','Underline'],
	['Subscript','Superscript'],
	['JustifyLeft','JustifyCenter','JustifyRight'],
	['Link','Unlink'],
	['Image','Smiley','SpecialChar'],
	['Table'],
	['OrderedList','UnorderedList','-','Outdent','Indent'],
	['FontName'],
	['FontSize'],
	['TextColor','BGColor'],
	['FitWindow']
] ;

// 4. 更换表情图片
//config.smiley_path	= CKEDITOR.basePath + 'plugins/smiley/images/wangwang/'; // 表情图片所在的文件夹
// 列出表情图片的文件名
//config.smiley_images	= ['0.gif','1.gif','2.gif','3.gif','4.gif','5.gif','6.gif','7.gif','8.gif','9.gif','10.gif','11.gif','12.gif','13.gif','14.gif','15.gif','16.gif','17.gif','18.gif','19.gif','20.gif','21.gif','22.gif','23.gif','24.gif','25.gif','26.gif','27.gif','28.gif','29.gif','30.gif','31.gif','32.gif','33.gif','34.gif','35.gif','36.gif','37.gif','38.gif','39.gif','40.gif','41.gif','42.gif','43.gif','44.gif','45.gif','46.gif','47.gif','48.gif','49.gif','50.gif','51.gif','52.gif','53.gif','54.gif','55.gif','56.gif','57.gif','58.gif','59.gif','60.gif','61.gif','62.gif','63.gif','64.gif','65.gif','66.gif','67.gif','68.gif','69.gif','70.gif','71.gif','72.gif','73.gif','74.gif','75.gif','76.gif','77.gif','78.gif','79.gif','80.gif','81.gif','82.gif','83.gif','84.gif','85.gif','86.gif','87.gif','88.gif','89.gif','90.gif','91.gif','92.gif','93.gif','94.gif','95.gif','96.gif','97.gif','98.gif','test.gif'] ;
//config.smiley_columns = 9;

// 4. 更换表情图片
config.smiley_path	= CKEDITOR.basePath + 'plugins/smiley/images/TUSKI/'; // 表情图片所在的文件夹
// 列出表情图片的文件名
config.smiley_images	= ['01.gif','02.gif','03.gif','04.gif','05.gif','06.gif','07.gif','08.gif','09.gif','10.gif','11.gif','12.gif','13.gif','14.gif','15.gif','16.gif','17.gif','18.gif','19.gif','20.gif','21.gif','22.gif','23.gif','24.gif','25.gif','26.gif','27.gif','28.gif','29.gif','30.gif','31.gif','32.gif','33.gif','34.gif','35.gif','36.gif','37.gif','38.gif'] ;
config.smiley_columns = 8;


};




//a.config.smiley_path=a.config.smiley_path||this.path+"images/";
//a.addCommand("smiley",
//new CKEDITOR.dialogCommand("smiley",
//{allowedContent:"img[alt,height,!src,title,width]",requiredContent:"img"}));
//a.ui.addButton&&a.ui.addButton("Smiley",
//{label:a.lang.smiley.toolbar,command:"smiley",toolbar:"insert,50"});
//CKEDITOR.dialog.add("smiley",this.path+"dialogs/smiley.js")}});
//CKEDITOR.config.smiley_images="regular_smile.png sad_smile.png wink_smile.png teeth_smile.png confused_smile.png tongue_smile.png embarrassed_smile.png omg_smile.png whatchutalkingabout_smile.png angry_smile.png angel_smile.png shades_smile.png devil_smile.png cry_smile.png lightbulb.png thumbs_down.png thumbs_up.png heart.png broken_heart.png kiss.png envelope.png".split(" ");
