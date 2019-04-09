let mapleader=" "

command! W :w
command! Q :q
command! WQ :wq
command! Wq :wq

set winwidth=1000
colorscheme zellner

autocmd BufNewFile *.cpp 0r ~/Skeletons/template.cpp
autocmd BufNewFile *.java 0r ~/Skeletons/template.java

set hlsearch " highlight the search matches
set incsearch " search as characters are typed
set ignorecase
set smartcase
set number " show linenumbers on side
set autoindent
set ruler " show cursor location x y coordinates
set cursorline " underline/highlight current line 
set showmatch " highlights matching braces and parenthesis

" set up tab width
set tabstop=2 "the width of a tab is set to 2
set shiftwidth=2 "indents will have a width of 2
set softtabstop=2 "sets the number of columns for a TAB
set expandtab "expands TABs to spaces

" press F4 to fix indentation in the whole file
noremap <F4> mqggVG=`qzz
inoremap <F4> <Esc>mqggVG=`qzza

" map <F8> to compile and <F9> to run java programs
map <F8> :set makeprg=javac\ %<CR>:make<CR>
map <F9> :!echo %\|awk -F. '{print $1}'\|xargs java<CR>

inoremap jj <Esc> " make "j j" be the new esc button for easy access

" make movements go by visual line rather than \n character
noremap <silent> k gk
noremap <silent> j gj
noremap <silent> 0 g0
noremap <silent> $ g$

nnoremap <leader>u : GundoToggle<CR> " still need to actually install this
