command! W :w
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

" press F4 to fix indentation in the whole file
noremap <F4> mqggVG=`qzz
inoremap <F4> <Esc>mqggVG=`qzza
