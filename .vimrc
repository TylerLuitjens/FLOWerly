command! W :w
command! Q :q
set winwidth=1000
colorscheme zellner
autocmd BufNewFile *.cpp 0r ~/Skeletons/template.cpp
autocmd BufNewFile *.java 0r ~/Skeletons/template.java
set hlsearch
set incsearch
set ignorecase
set smartcase
set number
set autoindent
" set up tab width
set tabstop=2 "the width of a tab is set to 2
set shiftwidth=2 "indents will have a width of 2
set softtabstop=2 "sets the number of columns for a TAB
set expandtab "expands TABs to spaces

" press F4 to fix indentation in the whole file
noremap <F4> mqggVG=`qzz
inoremap <F4> <Esc>mqggVG=`qzza
