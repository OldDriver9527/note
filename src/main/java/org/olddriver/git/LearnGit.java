package org.olddriver.git;
/**
 *
 * git笔记
 *
 */
public class LearnGit {
	/*
	 * git 
	 * 分布式版本控制系统
	 * 与集中式版本控制系统（如svn）相比，git不需在中央服务器存储版本库，git不需联网
	 * 就能使用
	 * 
	 * git下载
	 * git不能从官网下载，需在国内镜像网站下载
	 * 
	 * git配置
	 * git安装完毕，需配置环境变量
	 * git环境变量存储在三个位置，对应三个不同选项
	 * git config --global user.name 	命令用于配置用户名
	 * git config --global user.email	命令用于配置邮箱
	 * 
	 * 创建git本地仓库
	 * 创建git本地仓库存在两种方式
	 * 1.使用git init命令，将本地目录转变为git本地仓库
	 * 2.使用git clone命令，克隆远程仓库
	 * git仓库又称为工作区，工作区中包含git版本库（.git目录），git版本库中包含暂存区
	 * 
	 * 查看工作区，暂存区文件状态
	 * git中文件状态分为两类
	 * 未被跟踪	
	 * 已跟踪
	 * 已跟踪又划分为 未修改，已修改，已暂存
	 * 当工作区，暂存区中同一文件状态不同，会显示出同一文件的多个状态
	 * 使用git status 命令查看工作区，暂存区中文件状态
	 * 
	 * 将工作区文件添加到暂存区
	 * git add命令 将工作区文件添加到暂存区
	 * 未被跟踪文件 执行git add后 状态由未跟踪变为已暂存
	 * 
	 * 将暂存区快照提交版本库
	 * git commit 命令将暂存区快照提交版本库
	 * 
	 * 比较差异
	 * git diff 命令比较暂存区快照与工作区文件差异
	 * git diff --cached 命令比较暂存区快照与版本库中文件差异
	 * git diff HEAD 命令比较工作区文件与版本库中当前版本差异
	 * 
	 * 移除文件
	 * git rm命令移除工作区，暂存区中文件
	 * git rm -- cached 命令仅移除暂存区中文件
	 * 
	 * 查看提交历史
	 * git log命令查看当前所在分支的提交历史
	 * 
	 * 撤销最近一次提交
	 * git commit --amend 撤销最近一次提交，将当前暂存区快照提交，可以修改最近一次提交的说明
	 * 
	 * 将暂存区快照重置到指定版本
	 * git reset 命令将暂存区快照重置为指定版本
	 * 
	 * 将工作区文件恢复为暂存区快照
	 * git checkout -- file 命令将工作区文件恢复为暂存区快照
	 * 
	 * 远程仓库
	 * 托管在互联网上的git仓库
	 * 可以在github上创建远程仓库
	 * 在本地添加远程仓库配置
	 * git remote add 远程仓库名（git仓库目录名） url
	 * 将数据推送到远程仓库
	 * git push 远程仓库名 本地分支
	 * 移除远程仓库配置
	 * git remote rm 远程仓库名
	 * 重命名远程仓库名
	 * git remote rename oldname newname
	 * 
	 * 分支
	 * git每提交一次就会创建一个commit对象
	 * commit对象中封装着本次提交的相关数据，如提交人，父指针等
	 * 分支为指向commit对象的可变指针，每提交一次分支前移一位，指向最近提交的commit对象
	 * 
	 * 创建分支
	 * git branch 分支名 命令创建分支
	 * 新建分支与当前分支指向同意commit对象
	 * 
	 * 切换分支
	 * git checkout 分支名 用于将当前所在分支 切换为指定分支
	 * HEAD指针 指向当前所在分支
	 * git checkout -b 分支名 用于新建并切换分支
	 * 
	 * 删除分支
	 * git branch -d 分支名 用于删除指定分支
	 * 
	 * 查看分支
	 * git branch 用于查看所有分支
	 * 
	 *  合并分支
	 *  git merge 分支名 用于将指定分支合并到当前分支
	 *  合并分支时若提示fast forward，表示仅将指针移位
	 */
}
