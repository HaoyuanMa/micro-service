<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户名" prop="username">
      <el-input v-model="dataForm.username" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="dataForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item label="昵称" prop="nickname">
      <el-input v-model="dataForm.nickname" placeholder="昵称"></el-input>
    </el-form-item>
    <el-form-item label="手机号码" prop="mobile">
      <el-input v-model="dataForm.mobile" placeholder="手机号码"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="邮箱"></el-input>
    </el-form-item>
    <el-form-item label="头像" prop="header">
      <el-input v-model="dataForm.header" placeholder="头像"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="gender">
      <el-input v-model="dataForm.gender" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="省" prop="province">
      <el-input v-model="dataForm.province" placeholder="省"></el-input>
    </el-form-item>
    <el-form-item label="所在城市" prop="city">
      <el-input v-model="dataForm.city" placeholder="所在城市"></el-input>
    </el-form-item>
    <el-form-item label="区" prop="region">
      <el-input v-model="dataForm.region" placeholder="区"></el-input>
    </el-form-item>
    <el-form-item label="详细地址" prop="detailAddress">
      <el-input v-model="dataForm.detailAddress" placeholder="详细地址"></el-input>
    </el-form-item>
    <el-form-item label="职业" prop="job">
      <el-input v-model="dataForm.job" placeholder="职业"></el-input>
    </el-form-item>
    <el-form-item label="个性签名" prop="sign">
      <el-input v-model="dataForm.sign" placeholder="个性签名"></el-input>
    </el-form-item>
    <el-form-item label="状态 0:禁用 1:空闲 2:忙碌" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态 0:禁用 1:空闲 2:忙碌"></el-input>
    </el-form-item>
    <el-form-item label="粉丝数" prop="fansCount">
      <el-input v-model="dataForm.fansCount" placeholder="粉丝数"></el-input>
    </el-form-item>
    <el-form-item label="注册时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="注册时间"></el-input>
    </el-form-item>
    <el-form-item label="" prop="price">
      <el-input v-model="dataForm.price" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="dataForm.age" placeholder="年龄"></el-input>
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
          username: '',
          password: '',
          nickname: '',
          mobile: '',
          email: '',
          header: '',
          gender: '',
          province: '',
          city: '',
          region: '',
          detailAddress: '',
          job: '',
          sign: '',
          status: '',
          fansCount: '',
          createTime: '',
          price: '',
          age: ''
        },
        dataRule: {
          username: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '密码不能为空', trigger: 'blur' }
          ],
          nickname: [
            { required: true, message: '昵称不能为空', trigger: 'blur' }
          ],
          mobile: [
            { required: true, message: '手机号码不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' }
          ],
          header: [
            { required: true, message: '头像不能为空', trigger: 'blur' }
          ],
          gender: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          province: [
            { required: true, message: '省不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '所在城市不能为空', trigger: 'blur' }
          ],
          region: [
            { required: true, message: '区不能为空', trigger: 'blur' }
          ],
          detailAddress: [
            { required: true, message: '详细地址不能为空', trigger: 'blur' }
          ],
          job: [
            { required: true, message: '职业不能为空', trigger: 'blur' }
          ],
          sign: [
            { required: true, message: '个性签名不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态 0:禁用 1:空闲 2:忙碌不能为空', trigger: 'blur' }
          ],
          fansCount: [
            { required: true, message: '粉丝数不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '注册时间不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/fellow/fellow/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.username = data.fellow.username
                this.dataForm.password = data.fellow.password
                this.dataForm.nickname = data.fellow.nickname
                this.dataForm.mobile = data.fellow.mobile
                this.dataForm.email = data.fellow.email
                this.dataForm.header = data.fellow.header
                this.dataForm.gender = data.fellow.gender
                this.dataForm.province = data.fellow.province
                this.dataForm.city = data.fellow.city
                this.dataForm.region = data.fellow.region
                this.dataForm.detailAddress = data.fellow.detailAddress
                this.dataForm.job = data.fellow.job
                this.dataForm.sign = data.fellow.sign
                this.dataForm.status = data.fellow.status
                this.dataForm.fansCount = data.fellow.fansCount
                this.dataForm.createTime = data.fellow.createTime
                this.dataForm.price = data.fellow.price
                this.dataForm.age = data.fellow.age
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
              url: this.$http.adornUrl(`/fellow/fellow/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'username': this.dataForm.username,
                'password': this.dataForm.password,
                'nickname': this.dataForm.nickname,
                'mobile': this.dataForm.mobile,
                'email': this.dataForm.email,
                'header': this.dataForm.header,
                'gender': this.dataForm.gender,
                'province': this.dataForm.province,
                'city': this.dataForm.city,
                'region': this.dataForm.region,
                'detailAddress': this.dataForm.detailAddress,
                'job': this.dataForm.job,
                'sign': this.dataForm.sign,
                'status': this.dataForm.status,
                'fansCount': this.dataForm.fansCount,
                'createTime': this.dataForm.createTime,
                'price': this.dataForm.price,
                'age': this.dataForm.age
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
