layout 'layout.tpl', title:'Chat: help me',
  content: contents {
    div(class:'main__holder') {
      div(class: 'input') {
        form(id:'sendQuestionForm') {
          textarea(name:'question', id:'question', cols:80, row:5){}
          input(type:'submit', id:'submit', value:'submit')
        }
      }
      div(class: 'chat', id: 'main__messages') { content() }
    }
  }