import DefaultTheme from 'vitepress/theme'
import CodeShowcase from './CodeShowcase.vue'
import './custom.css'

export default {
  extends: DefaultTheme,
  enhanceApp({ app, router, siteData }) {
    app.component('CodeShowcase', CodeShowcase)
  }
}


