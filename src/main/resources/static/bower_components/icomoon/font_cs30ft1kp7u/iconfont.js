(function(window){var svgSprite='<svg><symbol id="icon-shoucang" viewBox="0 0 1024 1024"><path d="M1003.52 390.826667c-6.826667-20.48-23.893333-34.133333-44.373333-37.546667l-273.066667-42.666667L563.2 49.493333C554.666667 29.013333 534.186667 17.066667 512 17.066667s-40.96 11.946667-51.2 32.426666l-122.88 261.12-273.066667 40.96c-20.48 3.413333-37.546667 17.066667-44.373333 37.546667-6.826667 20.48-1.706667 42.666667 13.653333 56.32l199.68 204.8L186.026667 938.666667c-3.413333 20.48 5.12 42.666667 23.893333 54.613333 17.066667 11.946667 40.96 13.653333 59.733333 3.413333L512 865.28l244.053333 136.533333c8.533333 3.413333 17.066667 6.826667 25.6 6.826667 30.72 0 56.32-25.6 56.32-56.32 0-6.826667-1.706667-11.946667-3.413333-17.066667l-44.373333-279.893333 199.68-204.8c15.36-17.066667 20.48-39.253333 13.653333-59.733333z" fill="#040000" ></path></symbol></svg>';var script=function(){var scripts=document.getElementsByTagName("script");return scripts[scripts.length-1]}();var shouldInjectCss=script.getAttribute("data-injectcss");var ready=function(fn){if(document.addEventListener){if(~["complete","loaded","interactive"].indexOf(document.readyState)){setTimeout(fn,0)}else{var loadFn=function(){document.removeEventListener("DOMContentLoaded",loadFn,false);fn()};document.addEventListener("DOMContentLoaded",loadFn,false)}}else if(document.attachEvent){IEContentLoaded(window,fn)}function IEContentLoaded(w,fn){var d=w.document,done=false,init=function(){if(!done){done=true;fn()}};var polling=function(){try{d.documentElement.doScroll("left")}catch(e){setTimeout(polling,50);return}init()};polling();d.onreadystatechange=function(){if(d.readyState=="complete"){d.onreadystatechange=null;init()}}}};var before=function(el,target){target.parentNode.insertBefore(el,target)};var prepend=function(el,target){if(target.firstChild){before(el,target.firstChild)}else{target.appendChild(el)}};function appendSvg(){var div,svg;div=document.createElement("div");div.innerHTML=svgSprite;svgSprite=null;svg=div.getElementsByTagName("svg")[0];if(svg){svg.setAttribute("aria-hidden","true");svg.style.position="absolute";svg.style.width=0;svg.style.height=0;svg.style.overflow="hidden";prepend(svg,document.body)}}if(shouldInjectCss&&!window.__iconfont__svg__cssinject__){window.__iconfont__svg__cssinject__=true;try{document.write("<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>")}catch(e){console&&console.log(e)}}ready(appendSvg)})(window)