layout 'layout.tpl', title:'',
  content: contents {
    div(class:'main__holder') {
      div(class: 'input') {
        form(id:'sendQuestionForm') {
          textarea(name:'question', id:'question', cols:80, row:5){}
          input(type:'submit', id:'submit', value:'спросить')
        }
      }
      div(class: 'chat', id: 'main__messages') { content() }
    }
  }