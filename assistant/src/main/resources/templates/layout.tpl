html {
  script(src: 'sse.js')
  head {
    title(title)
  }
  body {
    div(class:'container') {
      h1(title)
      div { content() }
    }
  }
}