<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="fellow_id" prop="fellowId">
      <el-input v-model="dataForm.fellowId" placeholder="fellow_id"></el-input>
    </el-form-item>
    <el-form-item label="陪诊员名字" prop="fellowName">
      <el-input v-model="dataForm.fellowName" placeholder="陪诊员名字"></el-input>
    </el-form-item>
    <el-form-item label="用户昵称" prop="userNickName">
      <el-input v-model="dataForm.userNickName" placeholder="用户昵称"></el-input>
    </el-form-item>
    <el-form-item label="用户ip" prop="userIp">
      <el-input v-model="dataForm.userIp" placeholder="用户ip"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="显示状态[0-不显示，1-显示]" prop="showStatus">
      <el-input v-model="dataForm.showStatus" placeholder="显示状态[0-不显示，1-显示]"></el-input>
    </el-form-item>
    <el-form-item label="点赞数" prop="likesCount">
      <el-input v-model="dataForm.likesCount" placeholder="点赞数"></el-input>
    </el-form-item>
    <el-form-item label="回复数" prop="replyCount">
      <el-input v-model="dataForm.replyCount" placeholder="回复数"></el-input>
    </el-form-item>
    <el-form-item label="评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]" prop="resources">
      <el-input v-model="dataForm.resources" placeholder="评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]"></el-input>
    </el-form-item>
    <el-form-item label="内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="内容"></el-input>
    </el-form-item>
    <el-form-item label="用户头像" prop="userIcon">
      <el-input v-model="dataForm.userIcon" placeholder="用户头像"></el-input>
    </el-form-item>
    <el-form-item label="评论类型[0 - 对商品的直接评论，1 - 对评论的回复]" prop="commentType">
      <el-input v-model="dataForm.commentType" placeholder="评论类型[0 - 对商品的直接评论，1 - 对评论的回复]"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          fellowId: '',
          fellowName: '',
          userNickName: '',
          userIp: '',
          createTime: '',
          showStatus: '',
          likesCount: '',
          replyCount: '',
          resources: '',
          content: '',
          userIcon: '',
          commentType: ''
        },
        dataRule: {
          fellowId: [
            { required: true, message: 'fellow_id不能为空', trigger: 'blur' }
          ],
          fellowName: [
            { required: true, message: '陪诊员名字不能为空', trigger: 'blur' }
          ],
          userNickName: [
            { required: true, message: '用户昵称不能为空', trigger: 'blur' }
          ],
          userIp: [
            { required: true, message: '用户ip不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          showStatus: [
            { required: true, message: '显示状态[0-不显示，1-显示]不能为空', trigger: 'blur' }
          ],
          likesCount: [
            { required: true, message: '点赞数不能为空', trigger: 'blur' }
          ],
          replyCount: [
            { required: true, message: '回复数不能为空', trigger: 'blur' }
          ],
          resources: [
            { required: true, message: '评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]不能为空', trigger: 'blur' }
          ],
          content: [
            { required: true, message: '内容不能为空', trigger: 'blur' }
          ],
          userIcon: [
            { required: true, message: '用户头像不能为空', trigger: 'blur' }
          ],
          commentType: [
            { required: true, message: '评论类型[0 - 对商品的直接评论，1 - 对评论的回复]不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/fellow/fellowcomment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.fellowId = data.fellowComment.fellowId
                this.dataForm.fellowName = data.fellowComment.fellowName
                this.dataForm.userNickName = data.fellowComment.userNickName
                this.dataForm.userIp = data.fellowComment.userIp
                this.dataForm.createTime = data.fellowComment.createTime
                this.dataForm.showStatus = data.fellowComment.showStatus
                this.dataForm.likesCount = data.fellowComment.likesCount
                this.dataForm.replyCount = data.fellowComment.replyCount
                this.dataForm.resources = data.fellowComment.resources
                this.dataForm.content = data.fellowComment.content
                this.dataForm.userIcon = data.fellowComment.userIcon
                this.dataForm.commentType = data.fellowComment.commentType
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/fellow/fellowcomment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'fellowId': this.dataForm.fellowId,
                'fellowName': this.dataForm.fellowName,
                'userNickName': this.dataForm.userNickName,
                'userIp': this.dataForm.userIp,
                'createTime': this.dataForm.createTime,
                'showStatus': this.dataForm.showStatus,
                'likesCount': this.dataForm.likesCount,
                'replyCount': this.dataForm.replyCount,
                'resources': this.dataForm.resources,
                'content': this.dataForm.content,
                'userIcon': this.dataForm.userIcon,
                'commentType': this.dataForm.commentType
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
