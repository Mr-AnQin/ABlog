<template>
  <header ref="header">
    <div class="view">
      <img ref="imgbg1" src="https://blog-1312110814.cos.ap-shanghai.myqcloud.com/images/2023-7-29%2011%3A20%3A091690600808891.png" style="display: none;">
      <div class="bg1" style="background-image: url('https://blog-1312110814.cos.ap-shanghai.myqcloud.com/images/2023-7-29%2011%3A20%3A091690600808891.png');"></div>
<!--      <div class="bg2" style="background-image: url('https://blog-1312110814.cos.ap-shanghai.myqcloud.com/images/2022-12-11%2014%3A12%3A451670739285066.png');"></div>-->
<!--      <div class="bg3" style="background-image: url('https://blog-1312110814.cos.ap-shanghai.myqcloud.com/images/2022-12-11%2014%3A12%3A451670739285066.png');" v-show="loaded"></div>-->
    </div>
    <div class="text-malfunction" data-word="🍀众里寻他千百度，蓦然回首，那人却在，灯火阑珊处🍀 ">
      <!--    <div class="line"></div>-->
    </div>



    <div class="wrapper">
      <i class="ali-iconfont icon-down" @click="scrollToMain"></i>
    </div>
    <div class="wave1" style="background: url('https://fastly.jsdelivr.net/gh/Naccl/blog-resource/img/wave1.png') repeat-x;"></div>
    <div class="wave2" style="background: url('https://fastly.jsdelivr.net/gh/Naccl/blog-resource/img/wave2.png') repeat-x;"></div>
  </header>
</template>

<script>
import {mapState} from 'vuex'
export default {
  name: "Header",
  data() {
    return {
      loaded: false
    }
  },
  computed: {
    ...mapState(['clientSize'])
  },
  watch: {
    'clientSize.clientHeight'() {
      this.setHeaderHeight()
    }
  },
  mounted() {
    /**
     * 因为bg3.jpg比较小，通常会比bg1.jpg先加载，显示出来会有一瞬间bg1显示一半，bg3显示一半，为了解决这个问题，增加这个判断，让bg1加载完毕后再显示bg3
     * HTML中使用img标签的原因：我个人想用div作为图片的载体，而只有img标签有图片加载完毕的onload回调，所以用一个display: none的img人柱力来加载图片
     * 当img中的src加载完毕后，会把图片缓存到浏览器，后续在div中用background url的形式将直接从浏览器中取出图片，不会下载两次图片
     */
    this.$refs.imgbg1.onload = () => {
      this.loaded = true
    }
    this.setHeaderHeight()
    let startingPoint
    const header = this.$refs.header
    header.addEventListener('mouseenter', (e) => {
      startingPoint = e.clientX
    })
    // header.addEventListener('mouseout', (e) => {
    //   header.classList.remove('moving')
    //   header.style.setProperty('--percentage', 0.5)
    // })
    // header.addEventListener('mousemove', (e) => {
    //   let percentage = (e.clientX - startingPoint) / window.outerWidth + 0.5
    //   header.style.setProperty('--percentage', percentage)
    //   header.classList.add('moving')
    // })
  },
  methods: {
    //根据可视窗口高度，动态改变首图大小
    setHeaderHeight() {
      //this.$refs.header.style.height = this.clientSize.clientHeight + 'px'
    },
    //平滑滚动至正文部分
    scrollToMain() {
      window.scrollTo({top: this.clientSize.clientHeight, behavior: 'smooth'})
    }
  },
}
</script>

<style scoped>



header {
  --percentage: 0.5;
  user-select: none;
}
.view {
  /*width:100%;*/
  /*height:100%;*/
  /*position:fixed;*/
  /*background-size:100% 100%;*/
  height: 55vh;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  display: flex;
  justify-content: center;
  transform: translatex(calc(var(--percentage) * 100px));
}

.view div {
  background-position: center center;
  background-size: cover;
  position: absolute;
  width: 110%;
  height: 100%;
}
.view .bg1 {
  z-index: 10;
  opacity: calc(1 - (var(--percentage) - 0.5) / 0.5);
}
.view .bg2 {
  z-index: 20;
  opacity: calc(1 - (var(--percentage) - 0.25) / 0.25);
}
.view .bg3 {
  left: -10%;
}
header .view,
header .bg1,
header .bg2 {
  transition: .2s all ease-in;
}
header.moving .view,
header.moving .bg1,
header.moving .bg2 {
  transition: none;
}

@font-face{
  font-family: 'fangYuan';
  src : url('../font/fangYuan.ttf'),
  url("../font/yuanXinKeAi.ttf") format('yuanXinKeAi');
}

@font-face{
  font-family: 'yuanXinKeAi';
  src : url("../font/yuanXinKeAi.ttf");
}
.text-malfunction {
  position: absolute;
  top: 57%;
  left: 50%;
  transform: translate(-50%, -50%) scale(1.7);
  width: 325px;
  font-size: 5px;
  font-weight: 500;
  font-family: "fangYuan", cursive, serif, sans-serif;
  color: transparent;
}
.line {
  position: absolute;
  width: 200px;
  left: -1px;
  height: 1px;
  background: black;
  z-index: 50;
  animation: lineMove 5s ease-out infinite;
}
.text-malfunction:before, .text-malfunction:after {
  content: attr(data-word);
  position: absolute;
  /*top: 0;*/
  height: 80px;
  /*overflow: hidden;*/
  filter: contrast(200%);

}

.text-malfunction:before {
  left: 0;
  /*color: #ffffff;*/
  /*text-shadow: 1px 0 0 #ffffff;*/
  z-index: 30;
  /*animation: malfunctionAni 0.95s infinite;*/
}

.text-malfunction:after {
  left: -1px;
  color: #0e0d0d;
  /*text-shadow: -1px 0 0 #ffffff;*/
  z-index: 40;
  mix-blend-mode: lighten;
  /*animation: malfunctionAni 1.1s infinite 0.2s;*/
}
@keyframes lineMove {
  9% {
    top: 38px;
  }
  14% {
    top: 8px;
  }
  18% {
    top: 42px;
  }
  22% {
    top: 1px;
  }
  32% {
    top: 32px;
  }
  34% {
    top: 12px;
  }
  40% {
    top: 26px;
  }
  43% {
    top: 7px;
  }
  99% {
    top: 30px;
  }
}
@keyframes malfunctionAni {
  10% {
    top: -0.4px;
    left: -1.1px;
  }
  20% {
    top: 0.4px;
    left: -0.2px;
  }
  30% {
    left: .5px;
  }
  40% {
    top: -0.3px;
    left: -0.7px;
  }
  50% {
    left: 0.2px;
  }
  60% {
    top: 1.8px;
    left: -1.2px;
  }
  70% {
    top: -1px;
    left: 0.1px;
  }
  80% {
    top: -0.4px;
    left: -0.9px;
  }
  90% {
    left: 1.2px;
  }
  100% {
    left: -1.2px;
  }
}
.wrapper {
  position: absolute;
  width: 100px;
  bottom: 300px;
  left: 0;
  right: 0;
  margin: auto;
  font-size: 26px;
  z-index: 100;
}
.wrapper i {
  font-size: 60px;
  opacity: 0.5;
  cursor: pointer;
  position: absolute;
  top: 55px;
  left: 20px;
  animation: opener .5s ease-in-out alternate infinite;
  transition: opacity .2s ease-in-out, transform .5s ease-in-out .2s;
}
.wrapper i:hover {
  opacity: 1;
}
@keyframes opener {
  100% {
    top: 65px
  }
}
.wave1, .wave2 {
  position: absolute;
  bottom: 0;
  transition-duration: .4s, .4s;
  z-index: 0;
}
.wave1 {
  height: 51%;
  width: 100%;
}
.wave2 {
  height: 53%;
  width: calc(100% + 100px);
  left: -100px;
}

</style>