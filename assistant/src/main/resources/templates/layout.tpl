html {
  script(src: 'https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js') { }
  script(src: 'sse.js') { }
  head {
    title(title)
    link(rel: 'stylesheet', type: 'text/css', media: 'all',href: 'base.css')
  }
  body {
    div(class:'container') {
      div { content() }
    }
  }
}